package com.alben.geocoding.service;

import com.alben.geocoding.model.AddressInfo;
import com.alben.geocoding.service.exception.GeocodingExternalServiceException;

public interface GeocodingExternalServiceApi {
	AddressInfo getAddress(double lat, double lng) throws GeocodingExternalServiceException;
}
