package com.phonepe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phonepe.model.CabDetails;
import com.phonepe.service.ICabService;

@RestController
@RequestMapping("/cab")
public class CabController {
	
	@Autowired
	private ICabService iCabService;
	

	@PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
	private String registerCabDetails(@RequestBody CabDetails cabDetails) {
		return iCabService.register(cabDetails);
	}

	
	@GetMapping("/cabAvailableCities")
	public List<String> cabAvailableCities(){
		return iCabService.cabAvailableCities();
	}
	
	@PutMapping(path="/changeCabCurrentLocation/{cabId}/{currLocation}")
	public String changeCabCurrentLocation(@PathVariable Long cabId,@PathVariable String currLocation) {
		return iCabService.changeCabCurrentLocation(cabId, currLocation);
	}
	
	@PutMapping(path="/changeCabStateForCabId/{cabId}/{cabState}")
	public String changeCabStateForCabId(@PathVariable Long cabId,@PathVariable String cabState) {
		return iCabService.changeCabStateForCabId(cabId, cabState);
	}
	
	@GetMapping(path="/bookedCabByCustomerLocation/{custId}/{customerLocation}/{lat1}/{lat2}/{lon1}/{lon2}")
	public String bookedCabByCustomerLocation(@PathVariable Long custId,@PathVariable String customerLocation,
											  @PathVariable double lat1,@PathVariable double lat2,@PathVariable double lon1,@PathVariable double lon2) {
		return iCabService.bookedCabByCustomerLocation(custId, customerLocation, lat1, lon1, lat2, lon2);
	}
}
