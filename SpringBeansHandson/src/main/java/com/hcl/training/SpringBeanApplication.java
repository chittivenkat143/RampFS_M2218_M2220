package com.hcl.training;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hcl.training.pojos.Department;
import com.hcl.training.pojos.Orgination;

public class SpringBeanApplication {
	public static void main(String[] args) {
		String configLocation = "beanContext.xml";
		
		//Instantiate the Spring IoC Container
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(configLocation);
		
		//Get the bean information from Spring IoC
		Orgination org = (Orgination) context.getBean("org");

		//Use the bean
		System.out.println(org.toString());
		Consumer<Department> departC = new Consumer<Department>() {
			public void accept(Department t) {
				System.out.println(t.toString());
			}
		};
		org.getDepartments().forEach(departC);
		
		System.out.println("------------------------------");
		Department deptComputer = (Department) context.getBean("deptComputer");
		
		/*If we have multiple same class type should mention qualifier or else it will throws org.springframework.beans.factory.NoUniqueBeanDefinitionException:*/
		Department deptComputerType = (Department) context.getBean("deptComputer", Department.class);// Based on Bean Id
		Department deptComputerQu = BeanFactoryAnnotationUtils.qualifiedBeanOfType(context, Department.class, "math");//Based on Qualifier
		
		System.out.println(deptComputer.toString() + "\t:" + deptComputer);
		System.out.println(deptComputerType.toString() + "\t:" + deptComputerType);
		System.out.println(deptComputerQu.toString());
		
	}
}
