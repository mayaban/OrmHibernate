package com.prats123.main;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prats123.entities.CategoryEntity;
import com.prats123.entities.ProductEntity;
import com.prats123.repositories.CategoryRepository;
import com.prats123.repositories.ProductRepository;

public class ManyToOne {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application-context.xml");
		
		
	CategoryRepository categoryRepository = (CategoryRepository) ctx.getBean("categoryRepository");
		
		System.out.println("***** creating product*****");
		ProductEntity product1 = new ProductEntity();
		product1.setName("Mac book");
		product1.setBrand("Apple");
		product1.setDescription("this is a macbook");
		product1.setPrice(1500d);
		product1.setCreatedAt(new Date());
		
		CategoryEntity categoryElectronics = categoryRepository.getCategoryByName("Electronics");
		
		product1.setCategory(categoryElectronics);
		
		
		ProductRepository productRepository = (ProductRepository) ctx.getBean("productRepository");
		productRepository.save(product1);
		
	}

	}


