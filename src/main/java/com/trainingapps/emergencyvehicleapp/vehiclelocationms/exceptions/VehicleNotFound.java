package com.trainingapps.emergencyvehicleapp.vehiclelocationms.exceptions;

/* Exception for entity not found in database */ 

public class VehicleNotFound extends Exception{
	public VehicleNotFound(String msg) {
		super(msg);
	}

}
