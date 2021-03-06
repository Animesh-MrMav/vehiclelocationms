package com.trainingapps.emergencyvehicleapp.vehiclelocationms.service;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.AddVehicleLocationRequest;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.UpdateVehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.VehicleLocationDetails;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions.VehicleNotFound;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/*Service Interface for business logic*/
@Validated
public interface IVehicleLocationService {
    VehicleLocationDetails add(@Valid AddVehicleLocationRequest requestData);

    VehicleLocationDetails update(@Valid UpdateVehicleLocation requestData) throws Exception;
    
    VehicleLocationDetails findVehicleLocationDetailsByVehicleNumber(@NotNull String vehicleNumber) throws VehicleNotFound;

    void deleteVehicleLocationById(@Min(1) Long id) ;

    VehicleLocationDetails findVehicleLocationDetailsById(@Min(1) Long id) throws VehicleNotFound;
    
    List<VehicleLocationDetails>findAll();

}
