package com.zhiheng.spgstudy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhiheng.spgstudy.domain.Coffees;

@Mapper
public interface CoffeeMapper {
	
	public List<Coffees> selectCoffee();
	
}
