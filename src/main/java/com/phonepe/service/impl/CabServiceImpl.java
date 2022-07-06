package com.phonepe.service.impl;

import java.util.Date;
import java.util.List;

import com.phonepe.enums.CabState;
import com.phonepe.service.ICabService;
import com.phonepe.utils.CabUtils;
import com.phonepe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonepe.model.BookingHistory;
import com.phonepe.model.CabDetails;
import com.phonepe.repository.CabRepository;


@Service
public class CabServiceImpl implements ICabService {
	
	@Autowired
	private CabRepository cabRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String register(CabDetails cabDetails) {
		cabDetails.setCabRegisterTime(new Date());
		cabDetails.setIdleTime(new Date());
		cabDetails.setOnTripTime(new Date());
		cabDetails.setCabState(CabState.IDLE);
		return cabRepository.save(cabDetails) !=null ? "Successfully Cab Data Inserted " : "cab Data is not Valid";
	}
	
	@Override
	public List<String> cabAvailableCities(){
		return cabRepository.cabAvailableCities();
	}
	
	
	@Override
	public String changeCabCurrentLocation(Long cabId, String currLocation) {
		return cabRepository.changeCabCurrentLocation(cabId, currLocation)!=null?
				"Cab's Current Location Successfully Updated for CabId :: " + cabId :
				"CabId not Valid :: " + cabId;
	}
	
	@Override
	public String changeCabStateForCabId(Long cabId, String cabState) {
		return cabRepository.changeCabStateForCabId(cabId, cabState)!=null ?
				"Cab's Current State Successfully Updated for CabId :: " + cabId :
		"CabId not Valid :: " + cabId;
	}
	
	@Override
	public String bookedCabByCustomerLocation(Long custId, String customerLocation, double lat1, double lon1, double lat2, double lon2) {
		Long cabId = cabRepository.assignCabByLocation(customerLocation).get(0);
		if (cabId !=null){
			changeCabStateForCabId(cabId,"ON_TRIP");
			changeCabCurrentLocation(cabId,customerLocation);
			BookingHistory bookingHistory = new BookingHistory();
			Double distance = CabUtils.distance(lat1,lon1,lat2,lon2,"K");
			bookingHistory.setDistance(distance);
			bookingHistory.setAmount(CabUtils.calculateAmountFromDistance(distance));
			bookingHistory.setCabId(cabId);
			bookingHistory.setCustId(custId);
			bookingHistory.setBookingTime(new Date());
		}else{
			return "Cab is not available for location :: " + customerLocation;
		}
		return "Cab Booked Successfully For CabId :: " + cabId + " And CustId :: " + custId;
	}
}