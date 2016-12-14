package com.alben.geocoding;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alben.geocoding.model.AddressInfo;
import com.alben.geocoding.service.GeocodingService;

@RestController
public class GeocoderController {

	@Autowired
	private GeocodingService geocodingService;
	
	@RequestMapping(value = "/getAddress", method = RequestMethod.GET)
	public AddressInfo getAddress(@RequestParam("lat") double lat, @RequestParam("lon") double lng) {
		return geocodingService.getAddress(lat, lng);
	}

	@RequestMapping(value = "/getCachedAddresses", method = RequestMethod.GET)
	public Collection<AddressInfo> getCachedAddresses() {
		return geocodingService.getCachedAddresses();
	}	
}
