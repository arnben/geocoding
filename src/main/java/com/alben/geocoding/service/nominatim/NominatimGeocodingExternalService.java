package com.alben.geocoding.service.nominatim;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alben.geocoding.model.AddressInfo;
import com.alben.geocoding.service.GeocodingExternalServiceApi;
import com.alben.geocoding.service.exception.GeocodingExternalServiceException;

@Service
public class NominatimGeocodingExternalService implements GeocodingExternalServiceApi {
	
	private static final Logger logger = Logger.getLogger(NominatimGeocodingExternalService.class);

	public AddressInfo getAddress(double lat, double lng) throws GeocodingExternalServiceException {
		
		try {
			RestTemplate template = new RestTemplate();
			String uri = getUrl(lat, lng);
			NominatimResponse response = template.getForObject(uri, NominatimResponse.class);
			logger.debug(response);
			return convertToAddressInfo(lat, lng, response);
		} catch (RestClientException e) {
			throw new GeocodingExternalServiceException("Error communicating with Nominatim server", e);
		} 
		
	}
	
	private AddressInfo convertToAddressInfo(double lat, double lng, NominatimResponse response) {
		if(response == null) {
			return null;
		}
		
		NominatimAddress addressResponse = response.getAddress();
		if(addressResponse == null) {
			return null;
		}
		
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setBldgNumber(addressResponse.getHouseNumber());
		addressInfo.setStreetName(addressResponse.getRoad());
		addressInfo.setSubAddress(addressResponse.getVillage());
		addressInfo.setCounty(addressResponse.getCounty());
		addressInfo.setState(addressResponse.getState());
		addressInfo.setCountry(addressResponse.getCountry());
		addressInfo.setPostalCode(addressResponse.getPostCode());
		addressInfo.setCountryCode(addressResponse.getCountryCode());
		addressInfo.setLat(lat);
		addressInfo.setLng(lng);
		addressInfo.setLookupDate(new Date());
		
		return addressInfo;
	}
	
	//can be externalized
	private String getUrl(double lat, double lng) {
		return "http://nominatim.openstreetmap.org/reverse?format=json&lat=" + lat + "&lon=" + lng + "&zoom=18&addressdetails=1";
	}

}
