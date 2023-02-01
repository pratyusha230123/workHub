package com.springcore.constDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreConceptsApplication.class, args);
		
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring.xml");
		//Vehicle veh = (Vehicle) ctxt.getBean("vehicle");
		Trip t = ctxt.getBean("trip", Trip.class);
		t.displayInfo();
	}

}
