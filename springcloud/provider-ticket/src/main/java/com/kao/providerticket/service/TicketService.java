package com.kao.providerticket.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String getTicket() {
        System.out.println("visite...");
        return "great show man";
    }
}
