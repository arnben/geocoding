package com.alben.geocoding.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AddressInfo {
	private double lat;
	private double lng;
	private String bldgNumber;
	private String streetName;
	private String subAddress;
	private String county;
	private String state;
	private int postalCode;
	private String country;
	private String countryCode;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private Date lookupDate;
	

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBldgNumber() {
		return bldgNumber;
	}

	public void setBldgNumber(String bldgNumber) {
		this.bldgNumber = bldgNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getLookupDate() {
		return lookupDate;
	}

	public void setLookupDate(Date lookupDate) {
		this.lookupDate = lookupDate;
	}
}
