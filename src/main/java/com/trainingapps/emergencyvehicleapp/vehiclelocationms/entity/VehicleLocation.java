package com.trainingapps.emergencyvehicleapp.vehiclelocationms.entity;

/* Entity or persistence state of project*/

import javax.persistence.*;
import java.util.Objects;

@Table(name="vehiclelocation")
@Entity
public class VehicleLocation {

    @GeneratedValue
    @Id
    private Long id;
    @Column(unique=true)
    private String vehicleNumber;
    private Long requestId;
    private Long pincode;
    private boolean servingRequest ;

    public VehicleLocation()
    {
    	
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public boolean isServingRequest() {
		return servingRequest;
	}

	public void setServingRequest(boolean servingRequest) {
		this.servingRequest = servingRequest;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleLocation other = (VehicleLocation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


  
    
}