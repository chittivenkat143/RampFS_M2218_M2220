package com.hcl.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hcl.training.pojos.Carrom;

public class AnnotationBasedApplciation {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotationContext.xml");
	
		Carrom carrom = (Carrom) context.getBean("carrom");
		carrom.setGameSize(4);
		System.out.println(carrom.typeOfGame() + ":\t" + carrom.gameName() + ":\t" + carrom.getCarromType());
		
	}
}
