package com.deerpointgroup.deerpointliquorstore.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deerpointgroup.deerpointliquorstore.product.Product;

@Controller
public class EmployeeServletController {

	@Autowired
	EmployeeService empService;

	@RequestMapping("/getOrder")
	public String getOrder(HttpServletRequest request, HttpServletResponse response) {

		return "employeePage";
	}

	@RequestMapping("/setProduct")
	public String setProduct(HttpServletRequest request, HttpServletResponse response) {
		Product p;

		// Get the data from request update in database
		// go to employee html page
		return "employeePage";
	}

	@RequestMapping("/setQuantity")
	public String setQuantity(HttpServletRequest request, HttpServletResponse response) {

		// Get the data from request update in database
		// go to employee html page
		return "employeePage";
	}
}
