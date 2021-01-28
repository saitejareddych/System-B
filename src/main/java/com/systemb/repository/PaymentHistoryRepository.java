package com.systemb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.systemb.model.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {

	@Query("select paymentHistory from PaymentHistory paymentHistory where paymentHistory.customerId = :customerId and paymentHistory.paymentDate between :fromDate and :toDate")
	   List<PaymentHistory> findByPaymentHistoryByDate(@Param("customerId") int  customerId, @Param("fromDate") LocalDate  fromDate, @Param("toDate") LocalDate  toDate );
}
