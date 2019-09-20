package com.prats123.main;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.CustomerEntity;
import com.prats123.entities.CustomerLoginEntity;
import com.prats123.repositories.CustomerRepository;

public class OneToOneOpposite {
	
	public static void main(String [] args){
		
		CustomerEntity cust= new CustomerEntity();
		cust.setName("nepal");
		cust.setPhone("12345678");
		cust.setEmail("nepal@yahoo.com");
		
		CustomerLoginEntity cl=new CustomerLoginEntity();
		cl.setUsername("hello");
		String password = DigestUtils.sha256Hex("1234567");
		cl.setPassword(password);
		cl.setCreatedAt(new Date());
		cl.setCustomer(cust);
		
		cust.setCustomerLoginEntity(cl);
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository customerRepository=(CustomerRepository) ctx.getBean("customerRepository");
		customerRepository.save(cust);
	}

}
