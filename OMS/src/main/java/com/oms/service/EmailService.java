package com.oms.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
    @Scheduled(cron = "0 0 9 * * *")
    public void sendPromotionEmails() {
        // check for customers approaching gold or platinum status
        // send email to customers
        System.out.println("Email Send Successfully");
    }
}
