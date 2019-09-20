package com.prats123.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.EmployeeEntity;
import com.prats123.entities.ProjectEntity;
import com.prats123.repositories.EmployeeRepository;
import com.prats123.repositories.ProjectRepository;

public class AddEmployeeToProjectMain {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("application-context.xml");
		
		ProjectRepository pr=(ProjectRepository) ctx.getBean("projectRepository");
		EmployeeRepository er=(EmployeeRepository) ctx.getBean("employeeRepository");
		
		EmployeeEntity ee=er.getEmployeeByEmail("kancha@nepali.com");
		ProjectEntity pe=pr.getprojectByName("atom");
		pe.getEmployee().add(ee);
		pr.update(pe);

	}

}
