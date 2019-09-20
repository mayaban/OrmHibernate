package com.prats123.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.EmployeeEntity;
import com.prats123.repositories.EmployeeRepository;

public class SaveEmployeeMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		 
		EmployeeRepository employeeRepository=(EmployeeRepository) ctx.getBean("employeeRepository");
		
		EmployeeEntity emp=new EmployeeEntity();
		emp.setName("kancha");
		emp.setEmail("kancha@nepali.com");
		emp.setPhone("123456098");
		emp.setPosition("hakim");
		
		
		EmployeeEntity emp1=new EmployeeEntity();
		emp1.setName("jetha");
		emp1.setEmail("jetha@jhapali.com");
		emp1.setPhone("1246780");
		emp1.setPosition("mantri");
		
		
		employeeRepository.save(emp);
		employeeRepository.save(emp1);

	} 

}
