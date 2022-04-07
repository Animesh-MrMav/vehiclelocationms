package com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto;

public class VehicleLocationDetails 
{
    private Long id;
    private String vehicleNumber;
    private Long requestId;
    private Long pincode;
    private boolean servingRequest;

    public VehicleLocationDetails()
    {}

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

	public VehicleLocationDetails(Long id, String vehicleNumber, Long requestId, Long pincode, boolean servingRequest) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.requestId = requestId;
		this.pincode = pincode;
		this.servingRequest = servingRequest;
	}

	

 
}
