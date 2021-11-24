package com.hcl.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hcl.training.javaconfig.JavaBasedBeanConfiguation;
import com.hcl.training.javaconfig.TrainingConfiguration;
import com.hcl.training.pojos.Apple;
import com.hcl.training.pojos.Micromax;

public class JavaBasedBeanApplication {
	
	public static void main(String[] args) {
		//ApplicationContext contextSingleton = new AnnotationConfigApplicationContext(JavaBasedBeanConfiguation.class);
		AnnotationConfigApplicationContext contextSingleton = new AnnotationConfigApplicationContext(JavaBasedBeanConfiguation.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.register(JavaBasedBeanConfiguation.class, TrainingConfiguration.class);
		context.refresh();
		
		Micromax micromax = context.getBean(Micromax.class);
		System.out.println(micromax.toString());
		
		Apple apple = context.getBean(Apple.class);
		//apple.initMethod();
		System.out.println(apple.toStringPrint());
		//apple.destroyMethod();
		
		Apple appleScope = contextSingleton.getBean(Apple.class);
		System.out.println(apple + "\n" + appleScope);
		
		// Clears the context and it will trigger destroy methods on Beans
		context.registerShutdownHook();  
		contextSingleton.registerShutdownHook();  
	}
}
