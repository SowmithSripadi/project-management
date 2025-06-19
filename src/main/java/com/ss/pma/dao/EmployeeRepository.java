package com.ss.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ss.pma.dto.EmployeeProject;
import com.ss.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery = true, value ="SELECT e.first_name as FirstName, e.last_name as LastName, count(pe.employee_id) as ProjectCount FROM employee e left join project_employee pe on e.employee_id = pe.employee_id GROUP BY e.first_name, e.last_name order by 3 desc")
	public List<EmployeeProject> employeeProjects();
}
