package com.alben.geocoding.service.nominatim;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NominatimAddress {
	
	@JsonProperty("house_number")
	private String houseNumber;
	private String road;
	private String village;
	private String county;
	private String state;
	private int postCode;
	private String country;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
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
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NominatimAddress [houseNumber=").append(houseNumber).append(", road=").append(road)
				.append(", village=").append(village).append(", county=").append(county).append(", state=")
				.append(state).append(", postCode=").append(postCode).append(", country=").append(country)
				.append(", countryCode=").append(countryCode).append("]");
		return builder.toString();
	}
}
