package com.jiuhaox.boot.jackson;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotationsInside
@JsonSerialize(using = DecimalSerializer.class)
public @interface Decimal {

    String decimalFormat() default "";

    RoundingMode roundingMode() default RoundingMode.HALF_UP;

    int scale() default 2;

    boolean trimZero() default true;

}