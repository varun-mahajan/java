package org.bytegeeks.learn;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@AnnotationForClass
@Component
@Order(value = 2)
public class AnnotationUser2 {

    @AnnotationForMethod
    @Order(value = 1)
    public void performFirst() {

    }

    @AnnotationForMethod
    @Order(value = 2)
    public void performSecond() {

    }

}
