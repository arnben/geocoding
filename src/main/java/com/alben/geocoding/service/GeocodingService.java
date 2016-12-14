package com.alben.geocoding.service;

import java.util.Collection;

import com.alben.geocoding.model.AddressInfo;

public interface GeocodingService {
	AddressInfo getAddress(double lat, double lng);
	Collection<AddressInfo> getCachedAddresses();
}
