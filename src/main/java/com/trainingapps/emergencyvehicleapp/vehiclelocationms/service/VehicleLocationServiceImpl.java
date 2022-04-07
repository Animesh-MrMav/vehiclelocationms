package com.trainingapps.emergencyvehicleapp.vehiclelocationms.service;


import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.AddVehicleLocationRequest;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.UpdateVehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.VehicleLocationDetails;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions.VehicleNotFound;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.repository.IVehicleLocationRepository;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.util.VehicleLocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VehicleLocationServiceImpl implements IVehicleLocationService {

    @Autowired
    private IVehicleLocationRepository repository;

    @Autowired
    private VehicleLocationUtil vutil;

    @Override
    public VehicleLocationDetails add(AddVehicleLocationRequest request) {
        VehicleLocation vl = new VehicleLocation();
        vl.setVehicleNumber(request.getVehicleNumber());
        vl.setRequestId(request.getRequestId());
        vl.setPincode(request.getPincode());
        boolean b= Boolean.valueOf((request.isServingRequest()));
        vl.setServingRequest(b);
        VehicleLocation des=repository.save(vl);
        VehicleLocationDetails desired=vutil.toVehicleLocationDetails(des);
        return desired;
    }
     
    @Override
    public VehicleLocationDetails update(UpdateVehicleLocation request) throws Exception {
        VehicleLocation vl1 =findVehicleLocationById(request.getId());
        if(vl1==null)
        {    /* VehicleLocation vl = new VehicleLocation();
              vl.setVehicleNumber(request.getVehicleNumber());
              vl.setRequestId(request.getRequestId());
              vl.setPincode(request.getPincode());
              boolean b= Boolean.valueOf((request.getServingRequest()));
              vl.setServingRequest(b);
        	  vl=repository.save(vl);
        	  VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl);
        	  return desired ; */
        	 throw new VehicleNotFound("the vehicle record trying to update doesnt exist");
        }
        else
        { deleteVehicleLocationById(vl1.getId());
          VehicleLocation vl2=new VehicleLocation();
          vl2.setVehicleNumber(request.getVehicleNumber());
          vl2.setRequestId(request.getRequestId());
          vl2.setPincode(request.getPincode());
          boolean b= Boolean.valueOf((request.getServingRequest()));
          vl2.setServingRequest(b);
    	  vl2=repository.save(vl2);
          VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl2);
          return desired; 
          }
    }  

    @Override
    public VehicleLocationDetails findVehicleLocationDetailsByVehicleNumber( String vehicleNumber) throws VehicleNotFound {
       VehicleLocation vl= repository.findByVehicleNumber(vehicleNumber);
        if(vl==null) {
            throw new VehicleNotFound("student not found for vehicleNumber="+vehicleNumber);
        }
        VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl);
        return desired;
    }

    @Override
    public VehicleLocationDetails findVehicleLocationDetailsById(Long id) throws VehicleNotFound {
       Optional<VehicleLocation> optional=repository.findById(id);
       if (!optional.isPresent()) {
           throw new VehicleNotFound("student not found for id=" + id);
       }
        VehicleLocationDetails desired=vutil.toVehicleLocationDetails(optional.get());
        return desired;
    }
    public VehicleLocation findVehicleLocationById(Long id) throws VehicleNotFound {
        Optional<VehicleLocation> optional=repository.findById(id);
        return optional.get();
     }

    @Override
    public void deleteVehicleLocationById(Long id)  {
        repository.deleteById(id);
    }

    @Override
    public List<VehicleLocationDetails> findAll() {
        List<VehicleLocation> vls = repository.findAll();
        List<VehicleLocationDetails>desired=vutil.toListVehicleLocationDetails(vls);
        return desired;
    }

}