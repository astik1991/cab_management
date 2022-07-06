package com.phonepe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonepe.model.BookingHistory;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Long> {
}
