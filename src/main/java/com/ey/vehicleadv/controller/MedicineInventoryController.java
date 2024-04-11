package com.ey.vehicleadv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.vehicleadv.bean.MedicineInventoryBean;
import com.ey.vehicleadv.service.MedicineInventoryService;

@RestController
@RequestMapping(path="/medicineInventory")
public class MedicineInventoryController {
	@Autowired
	MedicineInventoryService medicineInventoryService;
	
	@GetMapping(path="/getMedicineStatusByName")
	public MedicineInventoryBean getMedicineStatusByName(@RequestParam(name="medicine_name")String medicine_name) {
		MedicineInventoryBean medInvStstusByName=medicineInventoryService.getMedicineStatusByName(medicine_name);
		return medInvStstusByName;
	}

}
