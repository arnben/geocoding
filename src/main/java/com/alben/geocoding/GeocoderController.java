package com.alben.geocoding;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alben.geocoding.model.AddressInfo;
import com.alben.geocoding.service.GeocodingService;
import com.alben.geocoding.service.exception.GeocodingExternalServiceException;

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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage("Error occurred: " + e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(GeocodingExternalServiceException.class)
	public ResponseEntity<ErrorResponse> handleExtServiceException(GeocodingExternalServiceException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMessage(e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}	
	
}
