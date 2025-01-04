package com.example.demo.other;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PuyaAnnotationBody.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pouya {

    public String value() default "@gmail.com";

    public String message() default "Not Valid...";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
