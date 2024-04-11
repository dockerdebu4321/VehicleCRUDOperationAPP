package com.ey.vehicleadv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.vehicleadv.bean.RcOwnerBeans;
import com.ey.vehicleadv.bean.VehicleBean;
import com.ey.vehicleadv.entity.VehicleEntity;
import com.ey.vehicleadv.repository.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	  @Autowired 
	  RestTemplate restTemplate;

		public List<VehicleBean> getAllVehicleDetails() {

			List<VehicleBean> vehBeanList = new ArrayList<>();
			List<VehicleEntity> vehEntityList = vehicleRepository.findAll();
			for (VehicleEntity currentVehEntity : vehEntityList) {
				VehicleBean vehBean = new VehicleBean();
				vehBean.setId(currentVehEntity.getVid());
				vehBean.setBrand(currentVehEntity.getvBrand());
				vehBean.setName(currentVehEntity.getvName());
				vehBean.setType(currentVehEntity.getvType());
				vehBean.setAge(currentVehEntity.getvAge());
				vehBean.setHave_regd_number(currentVehEntity.isHave_regd_number());
				vehBean.setEvehicle_evolved(currentVehEntity.getEvehicle_evolved());
				// RestTemplate restTemplate=new RestTemplate();
				/*
				 * String
				 * requestUrl="http://localhost:8088/rcOwnerdetails/getRCdetailsByID?id="+
				 * currentVehEntity.getVid(); RcOwnerBeans resBeans
				 * =restTemplate.getForObject(requestUrl, RcOwnerBeans.class);
				 * vehBean.setOwner_name(resBeans.getOwner_name());
				 * vehBean.setRC_number(resBeans.getRC_number());
				 */

				String requestUrl = "http://localhost:8088/rcOwnerdetails/getRCdetails";
				RcOwnerBeans[] resBeans;
				try {
					resBeans = restTemplate.getForObject(requestUrl, RcOwnerBeans[].class);
					for (RcOwnerBeans currentRCBeans : resBeans) {
						for (VehicleBean currentVehBean : vehBeanList) {
							if (currentVehBean.getId() == currentRCBeans.getId()) {
								currentVehBean.setOwner_name(currentRCBeans.getOwner_name());
								currentVehBean.setRC_number(currentRCBeans.getRC_number());
							}
						}
					}
				} catch (Exception e) {
					System.out.println("Exception while calling to Jar Application");
				}

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
	public List<VehicleBean> getVehicleDetailsByBrand(String brand) {
		List<VehicleBean> vehBeanList = new ArrayList<>();
		List<VehicleEntity> vehEntityList = vehicleRepository.findAll();
		for (VehicleEntity currentVehEntity : vehEntityList) {
			VehicleBean vehBean = new VehicleBean();
			if(currentVehEntity.getvBrand().toUpperCase().contains(brand.toUpperCase())) {
				vehBean.setId(currentVehEntity.getVid());
				vehBean.setBrand(currentVehEntity.getvBrand());
				vehBean.setName(currentVehEntity.getvName());
				vehBean.setType(currentVehEntity.getvType());
				vehBean.setAge(currentVehEntity.getvAge());
				vehBean.setHave_regd_number(currentVehEntity.isHave_regd_number());
				vehBean.setEvehicle_evolved(currentVehEntity.getEvehicle_evolved());
				vehBeanList.add(vehBean);
				}
			}
		return vehBeanList;
	}
}