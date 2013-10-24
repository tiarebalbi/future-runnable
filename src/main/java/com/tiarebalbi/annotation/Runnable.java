package com.tiarebalbi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Runnable {
	
	/**
	 * Lista de parametros caso seja necessário dentro do método
	 * @return
	 */
	String[] params() default {};
	
}
