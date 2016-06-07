package org.bytegeeks.learn;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

@Component
@EnableScheduling
public class GroovyMain implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(GroovyMain.class);

    private static final String CODE_FILE = "code.groovy";

    private long lastModifiedTime = 0l;

    private static long executionCounter = 0;

    private GroovyScriptEngine scriptEngine;

    private static ApplicationContext appContext = null;

    @PostConstruct
    public void postInit() throws IOException {
        LOG.info(
                "Sample Groovy program illustrating dynamic code runtime with Groovy integration. Change the code.groovy file and the execution results will be printed");
        scriptEngine = new GroovyScriptEngine(".");
    }

    @Scheduled(fixedDelay = 1000)
    public void processGroovyCode() {
        try {
            File codeFile = new File(CODE_FILE);
            LOG.debug("Checking if re-run is needed: {}", codeFile.exists());
            if (codeFile.exists()) {
                if (lastModifiedTime != codeFile.lastModified()) {
                    executionCounter++;
                    lastModifiedTime = codeFile.lastModified();
                    Object result;
                    result = scriptEngine.run(CODE_FILE, new Binding());
                    LOG.info("Groovy script result: {}", result);

                }
            }
        } catch (Exception e) {
            LOG.error("Exception while executing script: {}", e.getMessage());
        }
    }

    public static void printCounter() {
        LOG.info("Groovy script has been executed {} times", executionCounter);
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        appContext = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

    public static Object getBean(String beanName) {
        Object bean = appContext.getBean(beanName);
        LOG.debug("Fetched bean name: {}. Type: {}", beanName, bean == null ? null : bean.getClass());
        return bean;
    }
}
