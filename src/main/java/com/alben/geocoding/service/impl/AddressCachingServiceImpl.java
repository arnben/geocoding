package com.alben.geocoding.service.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alben.geocoding.model.AddressInfo;
import com.alben.geocoding.service.AddressInfoCachingService;

@Service
public class AddressCachingServiceImpl implements AddressInfoCachingService {
	
	private static final int LIMIT = 10;
	
	private final static Map<String, AddressInfo> map = new LinkedHashMap<String, AddressInfo>(LIMIT) {

		private static final long serialVersionUID = 1L;

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<String, AddressInfo> eldest) {
			return size() > LIMIT;
		}
	};
	

	public synchronized void addAddress(AddressInfo addressInfo) {
		map.put(generateMapKey(addressInfo.getLat(), addressInfo.getLng()), addressInfo);
	}
	
	public Collection<AddressInfo> getAddressInfos() {
		return map.values();
	}

	public AddressInfo getAddressInfo(double lat, double lng) {
		return map.get(generateMapKey(lat, lng));
	}

	private String generateMapKey(double lat, double lng) {
		return lat + "," + lng;
	}
	
}
