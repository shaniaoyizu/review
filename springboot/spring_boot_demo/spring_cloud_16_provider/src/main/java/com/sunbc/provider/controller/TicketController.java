package com.sunbc.provider.controller;

import com.sunbc.provider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-07-14
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Value("${server.port}")
    String port;

    @GetMapping("/ticket")
    public String getTicket(){
        System.out.println(port);
        return ticketService.getTicket();
    }
}
