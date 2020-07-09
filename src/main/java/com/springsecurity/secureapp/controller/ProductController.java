package com.springsecurity.secureapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsecurity.secureapp.model.ApiResponse;


@Controller
@RequestMapping("/api/products")
public class ProductController {
   
	@GetMapping("")
	public ResponseEntity<?> getProductsList() {
		System.out.println("Products List");
		 return new ResponseEntity<ApiResponse>(
		          new ApiResponse(true, "Products API"), HttpStatus.OK);
	}
}
