package com.trainingapps.emergencyvehicleapp.vehiclelocationms.repository;

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/* The repository class which directly accesses the Database and
 *  extends JPA Data repository interface for simplicity*/

public interface IVehicleLocationRepository extends JpaRepository<VehicleLocation,Long>
{
	   
	    VehicleLocation findByVehicleNumber(String vehicleNumber);

	    

	   
}
