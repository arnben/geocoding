package com.alben.geocoding.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alben.geocoding.model.AddressInfo;
import com.alben.geocoding.service.AddressInfoCachingService;
import com.alben.geocoding.service.GeocodingExternalServiceApi;
import com.alben.geocoding.service.GeocodingService;

@Service
public class GeocodingServiceImpl implements GeocodingService {

	@Autowired
	private GeocodingExternalServiceApi serviceApi;
	
	@Autowired
	private AddressInfoCachingService cachingService;
	
	public AddressInfo getAddress(double lat, double lng) {
		AddressInfo addressInfo = cachingService.getAddressInfo(lat, lng);
		if(addressInfo == null) {
			addressInfo = serviceApi.getAddress(lat, lng);
			cachingService.addAddress(addressInfo);			
		}
		return addressInfo;
	}

	public Collection<AddressInfo> getCachedAddresses() {
		return cachingService.getAddressInfos();
	}

}
