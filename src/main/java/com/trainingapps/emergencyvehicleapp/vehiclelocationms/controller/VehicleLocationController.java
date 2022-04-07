package com.trainingapps.emergencyvehicleapp.vehiclelocationms.controller;

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.constants.CourseType;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.AddVehicleLocationRequest;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.VehicleLocationDetails;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions.InvalidStudentAgeException;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions.VehicleNotFound;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.service.IVehicleLocationService;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.util.VehicleLocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/vehiclelocation")
@RestController
public class VehicleLocationController {

    @Autowired
    private IVehicleLocationService service;

    @Autowired
    private VehicleLocationUtil studentUtil;


    //effective url =/students/add ,
    // @RequestMapping(path="/add",method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public VehicleLocationDetails add(@RequestBody AddVehicleLocationRequest requestData) throws Exception {
        VehicleLocationDetails response = service.add(requestData);
        return response;
    }
    
    @PostMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.deleteVehicleLocationById(id);
    }

    //efective url : /students/byid/idval, java->json
    //@RequestMapping(path="/byid/{id}",method=RequestMethod.GET)
    @GetMapping("/findbyid/{id}")
    public VehicleLocationDetails findVehicleLocationDetailsById(@PathVariable Long id) throws Exception {
        VehicleLocationDetails response = service.findVehicleLocationDetailsById(id);
        return response;
    }
    
    @GetMapping("/findbyvehiclenumber/{vehicleNumber}")
    public VehicleLocationDetails findVehicleLocationDetailsByVehicleNumber(@PathVariable String vehicleNumber) throws Exception {
        VehicleLocationDetails response = service.findVehicleLocationDetailsByVehicleNumber(vehicleNumber);
        return response;
    }

    @GetMapping("/all")
    public List<VehicleLocationDetails> fetchAll() {
        List<VehicleLocationDetails> response = service.findAll();
        return response;
    }


}
