package com.zhiheng.spgstudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.zhiheng.spgstudy.domain.Coffees;

@Component
public class CoffeeDao extends BaseDao {
	
	public CoffeeDao(SqlSession sqlSession) {
		super(sqlSession);
	}
	
	public List<Coffees> selectCoffee() {
		return this.sqlSession.selectList("selectCoffee");
	}
	
}
