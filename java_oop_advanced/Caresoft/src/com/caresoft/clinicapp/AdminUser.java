package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	private Integer employeeID;
	private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();  // Question: can this be instantiated separately/later?
	
    public AdminUser(Integer id) {
		super(id);
	}

	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
	}
    
	@Override
	public boolean assignPin(int pin) {
		if (String.valueOf(pin).length() != 6 ) {
			return false;
		} else {
			this.setPin(pin);
			return true;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID.equals(getId())) {
			return true;
		}
		authIncident();
		return false;
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    

}
