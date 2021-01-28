package com.systemb.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systemb.model.PaymentHistory;
import com.systemb.service.PaymentHistoryService;


@RestController
@RequestMapping("/systemb")
public class PaymentHistoryController {

	private static final Logger LOGGER=LoggerFactory.getLogger(PaymentHistoryController.class);

	@Autowired
	private PaymentHistoryService paymentHistoryService;

	@GetMapping("/getpaymenthistory/{id}/{fromdate}/{todate}")
	public ResponseEntity<List<PaymentHistory>> getPaymentHistory(@PathVariable("id") int customerId, @PathVariable("fromdate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate fromDate, @PathVariable("todate") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate toDate) {
		
		List<PaymentHistory> result= paymentHistoryService.getPaymentHistoryById(customerId, fromDate, toDate);

		return ResponseEntity.ok().body(result);
	}
}
