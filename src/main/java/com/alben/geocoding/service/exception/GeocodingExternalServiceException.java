package com.alben.geocoding.service.exception;

public class GeocodingExternalServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeocodingExternalServiceException(String message, Exception e) {
		super(message, e);
	}
	
	public GeocodingExternalServiceException(String message) {
		super(message);
	}
}
