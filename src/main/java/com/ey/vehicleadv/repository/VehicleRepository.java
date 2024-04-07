package com.ey.vehicleadv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ey.vehicleadv.entity.VehicleEntity;

import jakarta.transaction.Transactional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity,Integer> {

	 @Transactional
	  @Modifying
	  @Query(value = "UPDATE VEHICLEINFORMATION SET AGE = ? , BRAND = ? WHERE ID = ?", nativeQuery = true)
	   public void updateVehicle(@Param(value = "age") int age,  @Param(value = "brand") String brand,
			   @Param(value = "vid") int vid );
	
}
