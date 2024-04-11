package com.ey.vehicleadv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.vehicleadv.entity.MedicineInventoryEntity;

public interface MedicineInventoryRepository extends JpaRepository<MedicineInventoryEntity, Integer> {

}
