package com.trainingapps.emergencyvehicleapp.vehiclelocationms.repository;

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity.VehicleLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class VehicleLocationRepositoryImpl implements IVehicleLocationRepository {

    @PersistenceContext
    //   @Autowired
    private EntityManager entityManager;

    @Override
    public void add(VehicleLocation vl) {
        entityManager.persist(vl);
    }

    @Override
    public VehicleLocation findVehicleLocationById(Long id) {
        VehicleLocation vl = entityManager.find(VehicleLocation.class, id);
        return vl;
    }
    
    @Override
    public VehicleLocation findVehicleLocationByVehicleNumber(String vehicleNumber)
    {
    	 VehicleLocation vl = entityManager.find(VehicleLocation.class, vehicleNumber);
         return vl;
    }

    @Override
    public void deleteVehicleLocationById(Long id) {
        VehicleLocation vl = findVehicleLocationById(id);
        entityManager.remove(vl);
    }

    @Override
    public List<VehicleLocation> findAll() {
        String queryText = "from vehiclelocation";
        TypedQuery<VehicleLocation> query = entityManager.createQuery(queryText, VehicleLocation.class);
        List<VehicleLocation> values = query.getResultList();
        return values;
    }
}