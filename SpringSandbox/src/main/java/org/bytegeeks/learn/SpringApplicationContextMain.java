package org.bytegeeks.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextMain
{

    public SpringApplicationContextMain() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        new SpringApplicationContextMain();
    }

}