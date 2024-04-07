package com.ey.vehicleadv.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.vehicleadv.bean.VehicleBean;
import com.ey.vehicleadv.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping(path="/vehicle")
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	
	//@Tag(name = "get", description = "GET methods of Vehicle APIs")
	@Operation(
		      summary = "This API Retrieve all Vehicle details",
		      description = "This API Get all Vehicle details.")
		     // tags = { "Vehicle", "get" })
	@GetMapping(path="/getAllVehicleDetails")
	public List<VehicleBean> getAllVehicleDetails()
	{
		List<VehicleBean> vehList=vehicleService.getAllVehicleDetails();
		return vehList;
	}
	
	
	//http://localhost:8080/vehicle/entryNewVehicleDetails
	@Operation(
		      summary = "This API helps entering a new all Vehicle details",
		      description = "This API POSTs new all Vehicle details.")
	@PostMapping(path="/entryNewVehicleDetails")
	public String entryNewVehicleDetails(@RequestBody VehicleBean vBean) {
		int crteateVehID=vehicleService.entryNewVehicleDetails(vBean);
		return "You have entered a new vehicle details successfulll!!your VehicleID  "+ crteateVehID +"   save it for future";
	}
	//http://localhost:8080/vehicle/deleteVehicle?id=5
	@Operation(
		      summary = "This API helps DELETEs Vehicle details by vehicle id",
		      description = "This API helps DELETEs Vehicle details by vehicle id.")
	@DeleteMapping(path="/deleteVehicle")
	public String deleteVehicle(@RequestParam(name="id") int vid) {
		vehicleService.deleteVehicle(vid);
		return "Vehicle with ID " + vid + "  deleted successfully !!!";
	}
	//http://localhost:8080/vehicle/updateVehicleDetails?age=2&brand=Honda6fnjr&vid=3
	@Operation(
		      summary = "This API helps updating a Vehicle details by vehicle id",
		      description = "This API helps updating a Vehicle details by vehicle id.")
	@PutMapping(path="/updateVehicleDetails")
	public VehicleBean updateVehicle(@RequestParam(name = "age") int age,
			@RequestParam(name = "brand") String brand, @RequestParam(name = "vid") int vid) {
		VehicleBean updatedVeh = vehicleService.updateVehicleDetails(age,brand,vid);
		return updatedVeh;
	}
	
	
	
	
}
