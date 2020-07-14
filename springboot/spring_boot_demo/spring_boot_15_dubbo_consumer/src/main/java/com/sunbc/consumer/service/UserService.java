package com.sunbc.consumer.service;

import com.sunbc.provider.service.TicketService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * Created on 2020-07-14
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service
public class UserService {

    @DubboReference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了：" + ticket);
    }
}
