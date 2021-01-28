package com.kao.providerticket.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//加到spring容器中
@Component
//將服務發佈出去
@Service
public class TicketServiceImpl implements  TicketService{
    @Override
    public String getTicket() {
        return "voltar";
    }
}
