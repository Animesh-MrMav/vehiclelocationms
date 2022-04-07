package com.trainingapps.emergencyvehicleapp.vehiclelocationms.dto;

public class UpdateVehicleLocation
{
	    private Long id;
	    private String vehicleNumber;
	    private Long requestId;
	    private Long pincode;
	    private String servingRequest;
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
		public String getServingRequest() {
			return servingRequest;
		}
		public void setServingRequest(String servingRequest) {
			this.servingRequest = servingRequest;
		}
	    
	    
}
