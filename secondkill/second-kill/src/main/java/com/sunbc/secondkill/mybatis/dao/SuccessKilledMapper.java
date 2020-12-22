package com.sunbc.secondkill.mybatis.dao;


import com.sunbc.secondkill.mybatis.MyMapper;
import com.sunbc.secondkill.mybatis.entity.SuccessKilled;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SuccessKilledMapper extends MyMapper<SuccessKilled> {
}