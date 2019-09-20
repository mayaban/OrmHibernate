package com.prats123.main;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.CustomerEntity;
import com.prats123.entities.CustomerLoginEntity;
import com.prats123.repositories.CustomerLoginRepository;

public class OneToOne {
	
	public static void main
	(String [] args){
		CustomerLoginEntity cl=new CustomerLoginEntity();
//		cl.setUsername("Ram Bahadur");
//		String password = DigestUtils.sha256Hex("1234567");
//		cl.setPassword(password);
//		cl.setCreatedAt(new Date());
//		
//		CustomerEntity ce=new CustomerEntity();
//		ce.setName("Bomb");
//		ce.setEmail("bomb@gmail.com");
//		ce.setPhone("2222222222");
//		cl.setCustomer(ce);
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");

		CustomerLoginRepository customerLoginRepository=(CustomerLoginRepository) ctx.getBean("customerLoginRepository");
		//customerLoginRepository.save(cl);
		
		CustomerLoginEntity c2=customerLoginRepository.getByUsername("Ram Bahadur");
		System.out.println("***********");
		System.out.println(c2.toString());
		
		String password = DigestUtils.sha256Hex("08234721");
		c2.setPassword(password);
		c2.setUpdatedAt(new Date());
		
		customerLoginRepository.update(c2);
	}
}
