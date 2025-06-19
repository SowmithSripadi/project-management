package com.ss.pma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.pma.dao.EmployeeRepository;
import com.ss.pma.dao.ProjectRepository;
import com.ss.pma.dto.EmployeeProject;
import com.ss.pma.dto.ProjectStatuses;
import com.ss.pma.entities.Project;


@Controller

public class HomeController {
		
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects =  proRepo.findAll();
		List<EmployeeProject> employeesProjectCnt=  empRepo.employeeProjects();		
		List<ProjectStatuses> projectstatuses = proRepo.projectStatuses();
		ObjectMapper objectmapper = new ObjectMapper();
		String jsonString = objectmapper.writeValueAsString(projectstatuses);
		
		model.addAttribute("projectStatusesCnt",jsonString);
		model.addAttribute("projects", projects);		
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		return "main/home";
	}
}
