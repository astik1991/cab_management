package com.phonepe.model;

import com.phonepe.enums.CabState;
import com.phonepe.enums.CabType;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class CabDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private Long cabId;
	private String cabNumber;
	@Enumerated(EnumType.STRING)
	private CabType cabType;
	private String cabName;
	private Date cabRegisterTime;
	private String driverName;
	private String email;
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private CabState cabState;
	private String cabCurrentLocation;
	private Date idleTime;
	private Date onTripTime;
	
	
	public CabState getCabState() {
		return cabState;
	}

	public void setCabState(CabState cabState) {
		this.cabState = cabState;
	}

	public String getCabCurrentLocation() {
		return cabCurrentLocation;
	}

	public void setCabCurrentLocation(String cabCurrentLocation) {
		this.cabCurrentLocation = cabCurrentLocation;
	}

	public Date getIdleTime() {
		return idleTime;
	}

	public void setIdleTime(Date idleTime) {
		this.idleTime = idleTime;
	}

	public Date getOnTripTime() {
		return onTripTime;
	}

	public void setOnTripTime(Date onTripTime) {
		this.onTripTime = onTripTime;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getCabId() {
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

	public String getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}

	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}

	public Date getCabRegisterTime() {
		return cabRegisterTime;
	}

	public void setCabRegisterTime(Date cabRegisterTime) {
		this.cabRegisterTime = cabRegisterTime;
	}

}