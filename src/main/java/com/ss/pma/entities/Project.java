package com.ss.pma.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Project {
	
    @Id
    @SequenceGenerator(
        name = "project_seq",           // logical name
        sequenceName = "project_seq",   // actual DB sequence
        allocationSize = 1               // MUST match your DB’s INCREMENT BY 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "project_seq"
    )
	private long projectId;
	private String name;
	private String state; //started, inprogress, completed.
	private String description;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
			fetch = FetchType.LAZY)
	@JoinTable(name="projectEmployee" ,joinColumns = @JoinColumn(name="projectId"), inverseJoinColumns = @JoinColumn(name="employeeId"))
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project() {
		
	}
	
	public Project(String name, String state, String description) {
		super();
		this.name = name;
		this.state = state;
		this.description = description;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
