package com.gokdemiruzunkaya.annotationdata;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface Deneme {
}
