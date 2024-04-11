package com.ey.vehicleadv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ey.vehicleadv.entity.MedicineInventoryEntity;

import jakarta.transaction.Transactional;

public interface MedicineInventoryRepository extends JpaRepository<MedicineInventoryEntity, Integer> {
	@Transactional
	@Modifying
	@Query(value = "UPDATE medicine_inventory SET  stock = ? WHERE ID = ?", nativeQuery = true)
	public void updateMedInv(@Param(value = "stock") int stock, @Param(value = "id") int id);

	@Query(value = "Select id,medicine_name,stock from medicine_inventory where medicine_name=?", nativeQuery = true)
	public List<Object[]> findByMedicine_name(@Param(value="medicine_name") String medicine_name);
}
