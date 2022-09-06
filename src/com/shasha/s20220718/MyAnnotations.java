package com.shasha.s20220718;

import java.lang.annotation.*;

/**
 * @author ShaLuwei
 * @create 2022-07-18 21:12
 */
@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
