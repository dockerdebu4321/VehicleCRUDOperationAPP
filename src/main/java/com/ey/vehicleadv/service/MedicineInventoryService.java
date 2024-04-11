package com.ey.vehicleadv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.vehicleadv.bean.MedicineInventoryBean;
import com.ey.vehicleadv.bean.MedicineInventoryResponseBean;
import com.ey.vehicleadv.entity.MedicineInventoryEntity;
import com.ey.vehicleadv.repository.MedicineInventoryRepository;

@Service
public class MedicineInventoryService {

	@Autowired
	MedicineInventoryRepository medicineInventoryRepository;

	public MedicineInventoryBean getMedicineStatusByName(String medicineName) {

		MedicineInventoryBean medInvBean = new MedicineInventoryBean();
		List<MedicineInventoryEntity> medInvEntity = medicineInventoryRepository.findAll();
		boolean status = true;
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

	public MedicineInventoryResponseBean getMedInvByNameAmount(String medicine_name, int requiredDose) {
		MedicineInventoryResponseBean medInvResBean = new MedicineInventoryResponseBean();
		List<MedicineInventoryEntity> medInvEntity = medicineInventoryRepository.findAll();

		for (MedicineInventoryEntity currentMedicineInventory : medInvEntity) {
			if (currentMedicineInventory.getMedicine_name().equalsIgnoreCase(medicine_name)) {
				int remaining_dose = currentMedicineInventory.getAvailable_stock() - requiredDose;
				medInvResBean.setMessage("medicine drawed successfully");
				medInvResBean.setAvailableBalance(remaining_dose);
				medicineInventoryRepository.updateMedInv(remaining_dose, currentMedicineInventory.getId());
			} else {
				medInvResBean.setMessage("Medicine stock not present");
			}
		}
		return medInvResBean;
	}

	public MedicineInventoryResponseBean getMedInvByNameAmountV2(String medicine_name, int requiredDose) {
		MedicineInventoryResponseBean medInvResBean = new MedicineInventoryResponseBean();
		List<MedicineInventoryEntity> medInvEntity = medicineInventoryRepository.findAll();

		for (MedicineInventoryEntity currentMedicineInventory : medInvEntity) {
			if (currentMedicineInventory.getMedicine_name().equalsIgnoreCase(medicine_name)) {
				int remaining_dose = currentMedicineInventory.getAvailable_stock() - requiredDose;
				medInvResBean.setMessage("medicine drawed successfully");
				medInvResBean.setAvailableBalance(remaining_dose);
				// medicineInventoryRepository.updateMedInv(remaining_dose,currentMedicineInventory.getId());
				currentMedicineInventory.setAvailable_stock(remaining_dose);
				medicineInventoryRepository.save(currentMedicineInventory);
			} else {
				medInvResBean.setMessage("Medicine stock not present");
			}
		}
		return medInvResBean;
	}

	public MedicineInventoryResponseBean getMedInvByNameAmountV3(String medicine_name, int requiredDose) {
		MedicineInventoryResponseBean medInvResBean = new MedicineInventoryResponseBean();
		List<Object[]> result = medicineInventoryRepository.findByMedicine_name(medicine_name);
		boolean isMedExists = false;
		for (Object[] objArray : result) {
			if (medicine_name.equalsIgnoreCase(objArray[1].toString())) {
				int remainingDose = Integer.parseInt(objArray[2].toString())-requiredDose;
				medInvResBean.setMessage("medicine drawed successfully");
				medInvResBean.setAvailableBalance(remainingDose);
				isMedExists = true;
				medicineInventoryRepository.updateMedInv(remainingDose, Integer.parseInt(objArray[0].toString()));
				break;
			} 
		}
		if(isMedExists==false) {
			medInvResBean.setMessage("Medicine stock not present");
		}
		return medInvResBean;
	}
}
