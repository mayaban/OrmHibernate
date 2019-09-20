package com.prats123.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.CustomerEntity;
import com.prats123.repositories.CustomerRepository;

public class OrmMain {

	public static void main(String[] args) {
	 
		CustomerEntity cust=new CustomerEntity();
		cust.setName("gaalu");
		cust.setEmail("gaalu@gmail.com");
		cust.setPhone("21435369");
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("application-context.xml");
		CustomerRepository customerRepository=(CustomerRepository) ct.getBean("customerRepository");
		customerRepository.save(cust);
		

		System.out.println("**************************");
		List<CustomerEntity> customers = customerRepository.getCustomerByName("shubha");
		for(CustomerEntity c : customers) {
			System.out.println(c.toString());
		}
		
		System.out.println();
		System.out.println("**************************");
		
		
		CustomerEntity customer1 = customerRepository.getCustomerById(5l);
		System.out.println(customer1.toString());
		
		
		System.out.println("8888888888888888");
		
		CustomerEntity custUpdate=customerRepository.getCustomerById(8l);
		custUpdate.setEmail("yahoo.@gmail.com");
		custUpdate.setPhone("987654321");
		customerRepository.update(custUpdate);
		
		System.out.println("1111111111111111");
		
		List<CustomerEntity> cust1=customerRepository.getCustomerByPhone("2435365");
		System.out.println(cust1.toString());
		
	}

}
