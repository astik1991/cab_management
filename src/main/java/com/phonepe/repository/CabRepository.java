package com.phonepe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phonepe.model.CabDetails;

import javax.transaction.Transactional;


@Repository
public interface CabRepository extends CrudRepository<CabDetails, Long> {
	
	@Query("select c.cabCurrentLocation from CabDetails c order by c.cabCurrentLocation asc")
	List<String> cabAvailableCities();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update CabDetails c set c.cabCurrentLocation=:currLocation where c.cabId=:cabId")
	Integer changeCabCurrentLocation(@Param("cabId") Long cabId, @Param("currLocation") String currLocation);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update CabDetails c set c.cabState=:cabState where c.cabId=:cabId")
	Integer changeCabStateForCabId(@Param("cabId") Long cabId, @Param("cabState")  String cabState);


	@Query("select c.cabId from CabDetails c where c.cabCurrentLocation=:customerLocation and c.cabState='IDLE' order by idleTime desc")
	List<Long> assignCabByLocation(@Param("customerLocation") String customerLocation);
	
}
