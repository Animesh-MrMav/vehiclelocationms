package com.trainingapps.emergencyvehicleapp.vehiclelocationms.util;


import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.VehicleLocationDetails;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* Utility class to perform some handy operations */

@Component
public class VehicleLocationUtil {

    public VehicleLocationDetails toVehicleLocationDetails(VehicleLocation loc){
     
        VehicleLocationDetails desired=new VehicleLocationDetails(loc.getId(),loc.getVehicleNumber(),loc.getRequestId(),loc.getPincode(),loc.isServingRequest());
        return desired;
    }

    public List<VehicleLocationDetails> toListVehicleLocationDetails(Collection<VehicleLocation>loc){
        List<VehicleLocationDetails>desired=new ArrayList<>();
        for (VehicleLocation l:loc){
           VehicleLocationDetails response= toVehicleLocationDetails(l);
            desired.add(response);
        }
        return desired;
    }

}
