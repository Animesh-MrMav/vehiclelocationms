package com.trainingapps.emergencyvehicleapp.vehiclelocationms.repository;

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;

import java.util.List;

public interface IVehicleLocationRepository {

    void add(VehicleLocation student);

    VehicleLocation findVehicleLocationById(Long id);
    
    VehicleLocation findVehicleLocationByVehicleNumber(String vehicleNumber);
    
    void deleteVehicleLocationById(Long id);

    List<VehicleLocation>findAll();


}
