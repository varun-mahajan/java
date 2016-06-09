package org.bytegeeks.learn;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.CompilationCustomizer;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

@Component
@EnableScheduling
public class GroovyMain implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(GroovyMain.class);

    private static final String CODE_FILE = "code.groovy";

    private static long lastModifiedTime = 0l;

    private static long executionCounter = 0;

    private static ApplicationContext appContext = null;

    private static GroovyShell shell;

    private static Map<Object, Object> mapBindings = new HashMap<Object, Object>();

    @PostConstruct
    public void postInit() throws IOException {
        LOG.info(
                "Sample Groovy program illustrating dynamic code runtime with Groovy integration. Change the code.groovy file and the execution results will be printed");
    }

    @Scheduled(fixedDelay = 1000)
    public void processGroovyCode() {
        try {
            File codeFile = new File(CODE_FILE);
            if (codeFile.exists()) {
                if (lastModifiedTime != codeFile.lastModified()) {
                    LOG.info("Executing groovy script.");
                    executionCounter++;
                    lastModifiedTime = codeFile.lastModified();
                    Object result = shell.evaluate(codeFile);
                    LOG.info("Execution of groovy script completed with result: {}", result);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception while executing script: {}", e.getMessage());
        }
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        appContext = ctx;
        setGroovyEnvironment();
    }

    private void setGroovyEnvironment() {
        // Add all the defined beans in the groovy bindings so that they can be
        // easily accessible in groovy scripts
        String allBeansNames[] = appContext.getBeanDefinitionNames();
        for (String beanName : allBeansNames) {
            try {
            mapBindings.put(beanName, appContext.getBean(beanName));
            } catch (Exception e) {
                LOG.error("Unable to find bean reference for {}. It will not be available as variable in groovy script", beanName);
            }
        }
        mapBindings.put("groovyAppContext", appContext);

        ImportCustomizer customizer = new ImportCustomizer();
        // customizer.addStarImports("java");
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.addCompilationCustomizers(new CompilationCustomizer[] { customizer });

        shell = new GroovyShell(getClass().getClassLoader(), new Binding(mapBindings), configuration);

        LOG.debug("Successfully configured the Groovy environment");
    }

    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

    public static void printCounter() {
        LOG.info("Groovy script has been executed {} times", executionCounter);
    }

}
