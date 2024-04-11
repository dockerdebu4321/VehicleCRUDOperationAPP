package com.ey.vehicleadv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.vehicleadv.bean.MedicineInventoryBean;
import com.ey.vehicleadv.entity.MedicineInventoryEntity;
import com.ey.vehicleadv.repository.MedicineInventoryRepository;

@Service
public class MedicineInventoryService {

	@Autowired
	MedicineInventoryRepository medicineInventoryRepository;
	
	public MedicineInventoryBean getMedicineStatusByName(String medicineName) {
		
		MedicineInventoryBean medInvBean=new MedicineInventoryBean();
		List<MedicineInventoryEntity> medInvEntity=medicineInventoryRepository.findAll();
		boolean status=true;
		for (MedicineInventoryEntity currentMedicineInventory : medInvEntity) {
			if (currentMedicineInventory.getMedicine_name().equalsIgnoreCase(medicineName)) {
				status = true;
				break;
			} else {
				status = false;
			}

		}
		medInvBean.setAvailable_status(status);
		return medInvBean;
	}
}
