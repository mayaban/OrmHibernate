package com.prats123.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.ProjectEntity;
import com.prats123.repositories.ProjectRepository;

public class SaveProjectMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx =new ClassPathXmlApplicationContext("application-context.xml");
		
		ProjectRepository projectRepository=(ProjectRepository) ctx.getBean("projectRepository");
		
		ProjectEntity pe=new ProjectEntity();
		pe.setName("atom");
		pe.setBudget(20000d);
		pe.setDescription("this is atom bomb");
		pe.setLocation("hiroshima");
		
		ProjectEntity pe1=new ProjectEntity();
		pe1.setName("nuclear");
		pe1.setBudget(5000000d);
		pe1.setDescription("this is fission bomb");
		pe1.setLocation("nagasaki");
		
		//projectRepository.save(pe);
		projectRepository.save(pe1);
		

	}

}
