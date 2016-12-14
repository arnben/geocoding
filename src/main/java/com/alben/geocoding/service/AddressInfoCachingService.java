package com.alben.geocoding.service;

import java.util.Collection;

import com.alben.geocoding.model.AddressInfo;

public interface AddressInfoCachingService {
	void addAddress(AddressInfo addressInfo);
	Collection<AddressInfo> getAddressInfos();
	AddressInfo getAddressInfo(double lat, double lng);
}
