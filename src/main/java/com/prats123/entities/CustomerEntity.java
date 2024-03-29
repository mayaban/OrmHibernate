package com.prats123.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	public CustomerLoginEntity getCustomerLoginEntity() {
		return customerLoginEntity;
	}

	public void setCustomerLoginEntity(CustomerLoginEntity customerLoginEntity) {
		this.customerLoginEntity = customerLoginEntity;
	}

	@Column(name = "phone")
	private String phone;

	
	@OneToOne(mappedBy = "customer", 
			fetch= FetchType.EAGER, cascade= CascadeType.ALL)
	private CustomerLoginEntity customerLoginEntity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", customerLoginEntity="
				+ customerLoginEntity + "]";
	}








}
