package com.sunbc.provider.service.impl;

import com.sunbc.provider.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * Created on 2020-07-13
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
@DubboService
public class TickerServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
