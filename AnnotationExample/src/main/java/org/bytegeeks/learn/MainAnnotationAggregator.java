package org.bytegeeks.learn;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class MainAnnotationAggregator {

    private static final Logger LOG = LoggerFactory.getLogger(MainAnnotationAggregator.class);

    @Autowired
    ApplicationContext ctx;

    // Linked Hashmap to maintain the order of beans
    private Map<Object, List<Method>> mapMethods = Collections
            .synchronizedMap(new LinkedHashMap<Object, List<Method>>());

    @PostConstruct
    public void init() {
        // Get all the beans that have 'AnnotationForClass'
        Map<String, Object> annotatedClasses = ctx.getBeansWithAnnotation(AnnotationForClass.class);
        if (annotatedClasses != null && annotatedClasses.size() > 0) {
            List<Object> tempList = new ArrayList<Object>();
            tempList.addAll(annotatedClasses.values());

            // Sort the list of beans. For this to work, classes
            // should have annotated with @Order
            AnnotationAwareOrderComparator.sort(tempList);
            for (Object obj : tempList) {
                LOG.info("Registering {} bean", obj);
                mapMethods.put(obj, getAnnotatedMethods(obj));
            }
        }

        invokeAnnotatedMethods();
    }

    /**
     * Get all the methods that are annotated with 'AnnotationForMethod'
     * 
     * @param bean
     * @return
     */
    private List<Method> getAnnotatedMethods(Object bean) {
        List<Method> list = new ArrayList<Method>();
        for (Method m : bean.getClass().getMethods()) {
            if (m.isAnnotationPresent(AnnotationForMethod.class)) {
                list.add(m);
            }
        }

        // Sort the methods Order. For this to work, methods
        // should have annotated with @Order
        AnnotationAwareOrderComparator.sort(list);
        return list;
    }

    private void invokeAnnotatedMethods() {

        if (mapMethods != null && mapMethods.size() > 0) {
            for (Map.Entry<Object, List<Method>> entry : mapMethods.entrySet()) {
                Object bean = entry.getKey();
                List<Method> allMethods = entry.getValue();
                if (!CollectionUtils.isEmpty(allMethods)) {
                    for (Method method : allMethods) {
                        LOG.info("Calling {}.{}", bean.getClass().getName(), method.getName());
                        try {
                            method.invoke(bean);
                        } catch (Exception e) {
                            LOG.error("Unable to execute method: " + method + " on bean " + bean, e);
                        }
                    }

                }
            }
        }

    }

}
