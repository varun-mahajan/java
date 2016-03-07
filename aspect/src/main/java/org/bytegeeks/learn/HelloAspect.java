package org.bytegeeks.learn;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aspect class that intercept calls to List.add method
 */
@Aspect
public class HelloAspect {

    @Around("call(* java.util.List.add(..))")
    public Object beforePrintlnCall(ProceedingJoinPoint pjp) {
        System.out.println("About to make call to list add");
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("After list add done");
        return o;
    }

}