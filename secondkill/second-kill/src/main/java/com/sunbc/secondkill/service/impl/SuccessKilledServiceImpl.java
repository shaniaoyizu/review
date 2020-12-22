package com.sunbc.secondkill.service.impl;

import com.sunbc.secondkill.mybatis.dao.SeckillMapper;
import com.sunbc.secondkill.mybatis.dao.SuccessKilledMapper;
import com.sunbc.secondkill.mybatis.entity.SuccessKilled;
import com.sunbc.secondkill.service.SuccessKilledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by feibabm on 2017/9/11 0011.
 */
@Service
@Transactional
public class SuccessKilledServiceImpl implements SuccessKilledService {
    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Override
    public void saveSuccessKillBackend(String userPhone, long productId) {
        //更新用户订单状态
        successKilledMapper.updateByPrimaryKeySelective(new SuccessKilled(productId, Long.valueOf(userPhone), Byte.valueOf(0 + "")));

        //更新产品订单库存
        seckillMapper.updateNumber(productId);
    }
}
