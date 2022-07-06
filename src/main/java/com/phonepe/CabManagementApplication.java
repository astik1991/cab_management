package com.phonepe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabManagementApplication.class, args);
	}

//	void save(){
//		CabDetails cabDetails = new CabDetails();
//		cabDetails.setCabId(101l);
//		cabDetails.setCabName("Maruti");
//		cabDetails.setCabNumber("MH16623553");
//		cabDetails.setCabRegisterTime(new Date());
//		cabDetails.setDriverName("Raju");
//		cabDetails.setEmail("abc@gmail.com");
//		cabDetails.setPhoneNumber("93373635353");
//
//		CabDetails cabDetails1 = new CabDetails();
//		cabDetails1.setCabId(201l);
//		cabDetails1.setCabName("swift");
//		cabDetails1.setCabNumber("MH637377337");
//		cabDetails1.setCabRegisterTime(new Date());
//		cabDetails1.setDriverName("Vivek");
//		cabDetails1.setEmail("abc@gmail.com");
//		cabDetails1.setPhoneNumber("363636336");
//
//		iCabService.register(cabDetails);
//		iCabService.register(cabDetails1);
//	}
}
