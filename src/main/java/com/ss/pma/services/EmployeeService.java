package com.ss.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
		@Autowired
		IStaffRepository iRepo;
}
