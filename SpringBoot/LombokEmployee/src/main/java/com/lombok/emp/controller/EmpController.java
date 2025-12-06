package com.lombok.emp.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.lombok.emp.model.Employee;
@RestController
public class EmpController {
	@GetMapping("/employee")
	public Employee employee() {
		Employee emp = new Employee();
		emp.setId(101);
		emp.setEname("Alice Smith");
		return emp;
	}

}
