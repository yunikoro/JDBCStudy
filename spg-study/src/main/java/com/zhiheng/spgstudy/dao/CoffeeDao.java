package com.zhiheng.spgstudy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zhiheng.spgstudy.domain.Coffees;

public class CoffeeDao extends BaseDao {

	public CoffeeDao(SqlSession sqlSession) {
		super(sqlSession);
	}
	
	public List<Coffees> selectCoffee() {
		return this.sqlSession.selectList("selectCoffee");
	}
	
}
