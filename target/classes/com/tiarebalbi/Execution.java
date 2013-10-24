package com.tiarebalbi;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Set;

import org.reflections.Reflections;

import com.tiarebalbi.annotation.Runnable;
import com.tiarebalbi.sample.Logic1;

public class Execution {
	
	public static void main(String[] args) throws MalformedURLException {
		
		Logic1 aa = new Logic1();
		Reflections reflection = new Reflections(aa.getClass().getPackage().getName());
		Set<Method> methods = reflection.getMethodsAnnotatedWith(Runnable.class);
		System.out.println(methods.size());
		
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
