package com.alben.geocoding.service.nominatim;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NominatimResponse {

	@JsonProperty("place_id")
	private String placeId;
	
	@JsonProperty("licence")
	private String license;
	
	@JsonProperty("osm_type")
	private String osmType;
	
	@JsonProperty("osm_id")
	private String osmId;
	
	private double lat;
	private double lon;
	
	@JsonProperty("display_name")
	private String displayName;
	
	private NominatimAddress address;
	private List<Integer> boundingBox;
	
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getOsmType() {
		return osmType;
	}
	public void setOsmType(String osmType) {
		this.osmType = osmType;
	}
	public String getOsmId() {
		return osmId;
	}
	public void setOsmId(String osmId) {
		this.osmId = osmId;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public NominatimAddress getAddress() {
		return address;
	}
	public void setAddress(NominatimAddress address) {
		this.address = address;
	}
	public List<Integer> getBoundingBox() {
		return boundingBox;
	}
	public void setBoundingBox(List<Integer> boundingBox) {
		this.boundingBox = boundingBox;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NominatimResponse [placeId=").append(placeId).append(", license=").append(license)
				.append(", osmType=").append(osmType).append(", osmId=").append(osmId).append(", lat=").append(lat)
				.append(", lon=").append(lon).append(", displayName=").append(displayName).append(", address=")
				.append(address).append(", boundingBox=").append(boundingBox).append("]");
		return builder.toString();
	}
}
