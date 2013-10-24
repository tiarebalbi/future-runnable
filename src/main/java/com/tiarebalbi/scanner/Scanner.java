package com.tiarebalbi.scanner;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.tiarebalbi.annotation.Runnable;

import eu.infomas.annotation.AnnotationDetector;
import eu.infomas.annotation.AnnotationDetector.MethodReporter;

/**
 * 
 * Class para realizar o scan entre as classes usando a anotação {@link Runnable}
 * 
 * @author Tiarê Balbi Bonamini
 * @package com.tiarebalbi.scanner
 * @since 1.0 
 *
 */
public class Scanner {
	
	public Scanner() throws ScannerException {

		final MethodReporter reporter = new MethodReporter() {

			private int nThreads = 4;

			@SuppressWarnings("unchecked")
			@Override
			public Class<? extends Annotation>[] annotations() {
				return new Class[] { Runnable.class };
			}

			@Override
			public void reportMethodAnnotation(Class<? extends Annotation> annotation, String className, String methodName) {
				
				ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
				
				try {
					Class<?> classe = Class.forName(className);
					
					final Object instance = classe.newInstance();
					
					final Method metodo = classe.getMethod(methodName);
					if(metodo.isAnnotationPresent(Runnable.class)) {
						executorService.execute(new java.lang.Runnable() {
							@Override
							public void run() {
								try {
									metodo.invoke(instance);
								} catch (IllegalAccessException
										| IllegalArgumentException
										| InvocationTargetException e) {
									throw new ScannerException("Ocorreu um erro: " + e.getMessage());
									
								} 
							}
						});
					}

				} catch (ClassNotFoundException | SecurityException
						| IllegalArgumentException | IllegalAccessException
						| InstantiationException | NoSuchMethodException e) {
					throw new ScannerException("Ocorreu um erro: " + e.getMessage());
				}finally {
					executorService.shutdown();
				}
				

			}
		};
		final AnnotationDetector cf = new AnnotationDetector(reporter);
		try {
			cf.detect();
		} catch (IOException e) {
			throw new ScannerException("Ocorreu um erro: " + e.getMessage());
		}

	}

}
