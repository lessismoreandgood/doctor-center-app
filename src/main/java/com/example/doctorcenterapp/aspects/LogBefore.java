package com.example.doctorcenterapp.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RUNTIME)
public @interface LogBefore {
}
