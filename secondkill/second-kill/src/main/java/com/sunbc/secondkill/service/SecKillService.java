package com.sunbc.secondkill.service;


import com.sunbc.secondkill.mybatis.entity.Seckill;
import com.sunbc.secondkill.pojo.SecKillResult;

import java.util.List;

/**
 * Created by feibabm on 2017/9/6 0006.
 */
public interface SecKillService {

    List<Seckill> getAllSecKill();

    SecKillResult secKillProduct(String userPhone, long productId);
}
