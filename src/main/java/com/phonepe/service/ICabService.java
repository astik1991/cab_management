package com.phonepe.service;

import java.util.List;

import com.phonepe.model.BookingHistory;
import com.phonepe.model.CabDetails;

public interface ICabService {
	
	 String register(CabDetails cabDetails);
	 
	 List<String> cabAvailableCities();

	String changeCabCurrentLocation(Long cabId, String currLocation);

	 String changeCabStateForCabId(Long cabId, String cabState);

	String bookedCabByCustomerLocation(Long custId, String customerLocation, double lat1, double lon1, double lat2, double lon2);

}
