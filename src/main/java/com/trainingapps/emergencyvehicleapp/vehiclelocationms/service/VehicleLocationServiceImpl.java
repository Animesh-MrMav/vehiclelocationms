package com.trainingapps.emergencyvehicleapp.vehiclelocationms.service;

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.constants.CourseType;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.AddVehicleLocationRequest;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto.VehicleLocationDetails;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions.VehicleNotFound;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.repository.IVehicleLocationRepository;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.repository.VehicleLocationRepositoryImpl;
import com.trainingapps.emergencyvehicleapp.vehiclelocationms.util.VehicleLocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VehicleLocationServiceImpl implements IVehicleLocationService {

    @Autowired
    private IVehicleLocationRepository dao;

    @Autowired
    private VehicleLocationUtil vutil;

    @Override
    public VehicleLocationDetails add(AddVehicleLocationRequest request) {
        VehicleLocation vl = new VehicleLocation();
        vl.setVehicleNumber(request.getVehicleNumber());
        vl.setRequestId(request.getRequestId());
        vl.setPincode(request.getPincode());
        vl.setServingRequest(request.isServingRequest());
        dao.add(vl);
        VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl);
        return desired;
    }
     
    @Override
    public VehicleLocationDetails update(AddVehicleLocationRequest request) throws Exception {
        VehicleLocationDetails vl =findVehicleLocationDetailsByVehicleNumber(request.getVehicleNumber());
        if(vl==null)
        {
        	VehicleLocationDetails vl1=add(request);
        	return vl1 ;
        }
        else
        { deleteVehicleLocationById(vl.getId());
          VehicleLocation vl2=new VehicleLocation();
          vl2.setVehicleNumber(request.getVehicleNumber());
          vl2.setRequestId(request.getRequestId());
          vl2.setPincode(request.getPincode());
          vl2.setServingRequest(request.isServingRequest());
          dao.add(vl2);
          VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl2);
          return desired; 
          }
    }

    @Override
    public VehicleLocationDetails findVehicleLocationDetailsByVehicleNumber( String vehicleNumber) throws VehicleNotFound {
        VehicleLocation  vl= dao.findVehicleLocationByVehicleNumber(vehicleNumber);
        if(vl==null) {
            throw new VehicleNotFound("student not found for vehicleNumber="+vehicleNumber);
        }
        VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl);
        return desired;
    }

    @Override
    public VehicleLocationDetails findVehicleLocationDetailsById(Long id) throws VehicleNotFound {
        VehicleLocation vl=dao.findVehicleLocationById(id);
        if(vl==null)
        {
        	throw new VehicleNotFound("The ID is incorrect");
        }
        VehicleLocationDetails desired=vutil.toVehicleLocationDetails(vl);
        return desired;
    }

    @Override
    public void deleteVehicleLocationById(Long id)  {
        dao.deleteVehicleLocationById(id);
    }

    @Override
    public List<VehicleLocationDetails> findAll() {
        List<VehicleLocation> vls = dao.findAll();
        List<VehicleLocationDetails>desired=vutil.toListVehicleLocationDetails(vls);
        return desired;
    }

}