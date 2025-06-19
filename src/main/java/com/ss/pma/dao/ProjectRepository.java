package com.ss.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ss.pma.dto.ProjectStatuses;
import com.ss.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value="select state, count(*) as stateCounts from project group by state;")
	List<ProjectStatuses> projectStatuses();
	
}
