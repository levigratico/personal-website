package com.beverly.personal.test.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.IntroductionImpl;
import com.beverly.personal.interactors.implementations.UserImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.IntroductionModel;
import com.beverly.personal.model.Paragraph;
import com.beverly.personal.model.UserModel;

public class DatabaseOperationDaoTest {
	
   private Retrieve introductionImpl;	
   private Retrieve userImpl;
	
  @Before
  public void setup() {
	  introductionImpl = new IntroductionImpl();
	  userImpl = new UserImpl();
  }
	
  @Test
  public void findAllIntroductionImplTest() {
	  IntroductionModel rs = (IntroductionModel)DatabaseOperationDao.findAll(introductionImpl);
	  System.out.println(String.format("Title: %s", rs.getTitle().getContent()));
	  System.out.println(String.format("Skills: %s", rs.getSkills().getContent()));
	  for(Iterator<Paragraph> par = rs.getParagraph().iterator(); par.hasNext();) {
		  Paragraph temPar = par.next();
		  System.out.println(String.format("Paragraph %d: %s", temPar.getRank(), temPar.getContent()));
	  }
  }
  
  
  @Test 
  public void findByWhereUserImplTest() {
	  Map<String, Object> where = new HashMap<>();
	  where.put("username", "beverly");
	  where.put("password", "BEVlev12");
	  UserModel data = (UserModel)DatabaseOperationDao.findByWhere(userImpl, where);
	  if(data != null) {
		  System.out.println(String.format("Username: %s", data.getUsername()));
		  System.out.println(String.format("Password: %s", data.getPassword()));
	  } else {
		  System.out.println("object is null");
	  }
  }

}
