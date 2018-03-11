package com.beverly.personal.test.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.beverly.personal.common.Operations;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.util.SQLBuilder;

public class SQLBuilderTest {

	private SQLBuilder sqlbuilder;

	@Before
	public void setup() {
		sqlbuilder = new SQLBuilder();
	}

	@Test
	public void selectAllTest() {
		String query = sqlbuilder.selectAll().from("user_tbl").and("username", Operations.EQ, "beverly")
				.and("password", Operations.EQ, "BEVlev13").build();
		System.out.println(query);
	}
	
	@Test 
	public void selectTableTest() {
		
	}
	
	@Test 
	public void insertTest() {
		List<InsertObject> obj = new ArrayList<>();
		obj.add(new InsertObject("username", "levigratico"));
		obj.add(new InsertObject("password", "levigratico"));
		SQLBuilder builder = new SQLBuilder().insert("user_tbl");
		System.out.println(builder.buildInsert(obj));
	}
	
	@Test
	public void updateTest() {
		InsertObject obj = new InsertObject("username", "levi");
		QueryObject opt = new QueryObject();
		opt.setColumn("id");
		opt.setDatum(1);
		opt.setOpt(Operations.EQ);
		SQLBuilder builder = new SQLBuilder().update("user_tbl").prepareUpdateData(obj).where(opt);
		System.out.println(builder.buildUpdate());
		for(Iterator<Object> temp = builder.getValue().iterator(); temp.hasNext();) {
			Object tempData = temp.next();
			System.out.println(tempData);
		}
	}
	
	@Test 
	public void testUpload() {
		System.out.println(new File(String.format("src/main/webapp/resources/images/%s", "levi.jpg")).getAbsolutePath());
	}
	
	
	@Test 
	public void testTime() {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date();  
		    System.out.println(formatter.format(date));  
		
	}
	
}
