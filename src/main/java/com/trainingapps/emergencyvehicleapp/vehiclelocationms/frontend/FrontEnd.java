package com.trainingapps.emergencyvehicleapp.vehiclelocationms.frontend;

import java.util.*;

/* Front End layer implementation for manual testing */

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.AddVehicleLocationRequest;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.VehicleLocationDetails;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions.VehicleNotFound;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.service.IVehicleLocationService;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.service.VehicleLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontEnd {

    @Autowired
    private IVehicleLocationService service;

    public void runUI() {
        try {
            System.out.println("***adding Vehicle Location");
            AddVehicleLocationRequest requestData1 = new AddVehicleLocationRequest();
            requestData1.setVehicleNumber("UP32XX0007");
            requestData1.setPincode(226003L);
            requestData1.setRequestId(100000L);
            requestData1.setServingRequest("true");
            VehicleLocationDetails vl1 = service.add(requestData1);
            
            AddVehicleLocationRequest requestData2 = new AddVehicleLocationRequest();
            requestData2.setVehicleNumber("UP32XX0786");
            requestData2.setPincode(201206L);
            requestData2.setRequestId(100001L);
            requestData2.setServingRequest("false");
            VehicleLocationDetails vl2 = service.add(requestData2);
            
            display(vl1);
            display(vl2);
            
            System.out.println("***displaying student by id");
            Long vl1Id = vl1.getId();
            VehicleLocationDetails found = service.findVehicleLocationDetailsById(vl1Id);
            display(found);
            
            System.out.println("***displaying student by vehicleNumber");
            String vl2vn = vl2.getVehicleNumber();
            VehicleLocationDetails found1 = service.findVehicleLocationDetailsByVehicleNumber(vl2vn);
            display(found);
            
            System.out.println("****displaying all elements in store");
            List<VehicleLocationDetails> all = service.findAll();
            displayAll(all);
            
            System.out.println("****delete student by id");
            service.deleteVehicleLocationById(vl1Id);
            
            System.out.println("****displaying all elements in store");
            List<VehicleLocationDetails> all1 = service.findAll();
            displayAll(all1);
        }  catch (VehicleNotFound e) {
            //e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    void displayAll(Collection<VehicleLocationDetails> loc) {
        for (VehicleLocationDetails vl : loc) {
            display(vl);
        }
    }

    void display(VehicleLocationDetails vl) {
        System.out.println(vl.getId() + "-" + vl.getVehicleNumber() + "-" + vl.getPincode() + "-" + vl.getRequestId() + "-" + vl.isServingRequest() );          
    }

}
