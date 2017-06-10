package com.zhiheng.spgstudy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {
	
	protected final SqlSession sqlSession;

	public BaseDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	
}
