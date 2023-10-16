package com.cards.api.Util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PayPerMonthCronUtil {

    //@Scheduled(fixedRate = 5000)
    public void calculatePayment() {
        System.out.println("Task");
    }

    public void generatePaymentPerMonth() {

    }
}
