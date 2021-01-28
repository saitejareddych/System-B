package com.systemb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systemb.model.PaymentHistory;
import com.systemb.repository.PaymentHistoryRepository;


@Service
public class PaymentHistoryService {
	
	private PaymentHistoryRepository paymentHistoryRepository = null;

	@Autowired
	public PaymentHistoryService(PaymentHistoryRepository paymentHistoryRepository) {
		this.paymentHistoryRepository = paymentHistoryRepository;
	}
	
	public List<PaymentHistory> getPaymentHistoryById(int customerId, LocalDate fromDate, LocalDate toDate) {
		
		if(fromDate.isAfter(toDate))
			throw new IllegalArgumentException();
		
		return paymentHistoryRepository.findByPaymentHistoryByDate(customerId, fromDate, toDate);
	}

}
