package com.ey.vehicleadv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.vehicleadv.bean.VehicleBean;
import com.ey.vehicleadv.entity.VehicleEntity;
import com.ey.vehicleadv.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<VehicleBean> getAllVehicleDetails(){
		
		List<VehicleBean> vehBeanList= new ArrayList<>();
		List<VehicleEntity> vehEntityList=vehicleRepository.findAll();
		for( VehicleEntity currentVehEntity : vehEntityList) {
			VehicleBean vehBean=new VehicleBean();
			vehBean.setId(currentVehEntity.getVid());
			vehBean.setBrand(currentVehEntity.getvBrand());
			vehBean.setName(currentVehEntity.getvName());
			vehBean.setType(currentVehEntity.getvType());
			vehBean.setAge(currentVehEntity.getvAge());
			vehBean.setHave_regd_number(currentVehEntity.isHave_regd_number());
			vehBean.setEvehicle_evolved(currentVehEntity.getEvehicle_evolved());
			vehBeanList.add(vehBean);
	}
			return vehBeanList;
			}
	
	
	public int entryNewVehicleDetails(VehicleBean vBean) {
		VehicleEntity vehEntity=new VehicleEntity();
		vehEntity.setEvehicle_evolved(vBean.isEvehicle_evolved());
		vehEntity.setHave_regd_number(vBean.isHave_regd_number());
		vehEntity.setvAge(vBean.getAge());
		vehEntity.setvBrand(vBean.getBrand());
		vehEntity.setVid(vBean.getId());
		vehEntity.setvName(vBean.getName());
		vehEntity.setvType(vBean.getType());
		VehicleEntity vehSave=vehicleRepository.save(vehEntity);
		return vehSave.getVid();
	}
	public void deleteVehicle(int vid) {
		vehicleRepository.deleteById(vid);
	}
	public VehicleBean updateVehicleDetails(int age,String brand,int vid) {
		vehicleRepository.updateVehicle(age, brand, vid);
		Optional<VehicleEntity> vehEntityNullCheck= vehicleRepository.findById(vid);
		VehicleBean vehBean=new VehicleBean();
		try {
		VehicleEntity currentVehEntity=vehEntityNullCheck.get();
		vehBean.setId(currentVehEntity.getVid());
		vehBean.setBrand(currentVehEntity.getvBrand());
		vehBean.setName(currentVehEntity.getvName());
		vehBean.setType(currentVehEntity.getvType());
		vehBean.setAge(currentVehEntity.getvAge());
		vehBean.setHave_regd_number(currentVehEntity.isHave_regd_number());
		vehBean.setEvehicle_evolved(currentVehEntity.getEvehicle_evolved());
		}catch (Exception e) {
			System.out.println("Enter valid vehicleid");		    
		}
		return vehBean;
	}
}