package com.prats123.main;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.CategoryEntity;
import com.prats123.entities.ProductEntity;
import com.prats123.repositories.CategoryRepository;

public class OneToMany {
	
	public static void main(String [] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		
		CategoryEntity category=new CategoryEntity();
		category.setName("Electronics");
		category.setDescription("this is books");
		category.setCreatedAt(new Date());
		
		CategoryRepository categoryRepository=(CategoryRepository) ctx.getBean("categoryRepository");
		categoryRepository.save(category);
		
		CategoryEntity electronics = categoryRepository.getCategoryByName("Electronics");
		System.out.println("******category by name********");
		System.out.println(electronics.toString());
		
		ProductEntity productiphone = new ProductEntity();
		productiphone.setName("I phone X");
		productiphone.setDescription("this is iphone x unlocked");
		productiphone.setBrand("Apple");
		productiphone.setPrice(1119d);
		productiphone.setCreatedAt(new Date());
		productiphone.setIsAvailable(true);
		productiphone.setCategory(electronics);
		
		electronics.getProducts().add(productiphone);
		categoryRepository.update(electronics);
		
	}

}
