package com.prats123.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="project")
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="budget")
	private Double budget;
	
	@Column(name="location")
	private String location;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "project_employee",
		joinColumns = { @JoinColumn(name = "project_id") }, 
	    inverseJoinColumns = { @JoinColumn(name = "employee_id")})
	private List<EmployeeEntity> employee;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeEntity> employee) {
		this.employee = employee;
	}
	
	
	

}
