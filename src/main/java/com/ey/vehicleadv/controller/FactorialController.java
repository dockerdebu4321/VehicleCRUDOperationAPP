package com.ey.vehicleadv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.vehicleadv.bean.FactorialBean;
import com.ey.vehicleadv.service.FactorialService;

@RestController
@RequestMapping(path="/factorial")
public class FactorialController {
	
	@Autowired
	FactorialService factorialService;
	
	@GetMapping(path="/factorialOfNumber")
	public FactorialBean factorialOfNumber(@RequestParam(name="number") int number) {
		FactorialBean fBean=factorialService.factorialOfNumber(number);
		return fBean;
	}
	

}
