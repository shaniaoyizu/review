package com.sunbc.secondkill.mybatis.dao;

import com.sunbc.secondkill.mybatis.MyMapper;
import com.sunbc.secondkill.mybatis.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SeckillMapper extends MyMapper<Seckill> {
    //更新库存，减一
    int updateNumber(@Param("seckillId") long seckillId);
}