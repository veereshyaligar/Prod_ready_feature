package com.codingshuttle.prod_ready_feature3;

import com.codingshuttle.prod_ready_feature3.Client.EmployeeClient;
import com.codingshuttle.prod_ready_feature3.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployees() {
		List<EmployeeDTO> getList= employeeClient.getAllEmployee();

		System.out.println(getList);

	}

}
