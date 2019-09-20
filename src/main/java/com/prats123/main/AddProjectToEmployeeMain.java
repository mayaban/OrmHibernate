package com.prats123.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.EmployeeEntity;
import com.prats123.entities.ProjectEntity;
import com.prats123.repositories.EmployeeRepository;
import com.prats123.repositories.ProjectRepository;

public class AddProjectToEmployeeMain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeRepository er=(EmployeeRepository) ctx.getBean("employeeRepository");
		
		ProjectRepository pr=(ProjectRepository) ctx.getBean("projectRepository");
		
		EmployeeEntity ee=er.getEmployeeByEmail("jetha@jhapali.com");
		ProjectEntity pe=pr.getprojectByName("nuclear");
		ee.getProjects().add(pe);
		
		er.update(ee);
 
	}

}
