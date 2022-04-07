package com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/* DTO or data transfer object for creating in database*/

public class AddVehicleLocationRequest {
	    
	 
	    private String vehicleNumber;
	    private Long requestId;
	    private Long pincode;
	    private String servingRequest;
		
	    public AddVehicleLocationRequest()
	    {}
	    
	   
	    
	    
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
		public String isServingRequest() {
			return servingRequest;
		}
		public void setServingRequest(String servingRequest) {
			this.servingRequest = servingRequest;
		}


    
}
