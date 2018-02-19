package org.bytegeeks.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain
{

    public SpringApplicationContextMain() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.close();
        while (true) {
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationContextMain();
    }

}