package com.beverly.personal.test.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.beverly.personal.model.UserQueryPreparation;
import com.beverly.personal.util.QueryBuilder;

public class QueryBuilderTest {

	@Before
	public void setup() {
		
	}
	
	@Test
	public void buildTest() {
		String sqlQuery = "SELECT * FROM user_tbl WHERE ";
		String separator = " AND";
		Map<String, Object> where = new HashMap<>();
		where.put("username", "beverly");
		where.put("password", 1);
		UserQueryPreparation result = QueryBuilder.build(sqlQuery, where, separator);
		System.out.println(String.format("query: %s", result.getQuery()));
		for(Iterator<Object> tempObj = result.getData().iterator(); tempObj.hasNext();) {
			System.out.println(tempObj.next());
		}
	}

}
