package com.beverly.personal.test.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.beverly.personal.common.BoleanOperators;
import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.common.Operations;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.IntroductionImpl;
import com.beverly.personal.interactors.implementations.PhotosImpl;
import com.beverly.personal.interactors.implementations.ProfileImpl;
import com.beverly.personal.interactors.implementations.UserImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.IntroductionModel;
import com.beverly.personal.model.Paragraph;
import com.beverly.personal.model.ProfileModel;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.ServicesModel;
import com.beverly.personal.model.UserModel;

public class DatabaseOperationDaoTest {
	
   private Retrieve introductionImpl;	
   private Retrieve userImpl;
   private Retrieve profileImpl;
   private Retrieve photosImpl;
	
  @Before
  public void setup() {
	  introductionImpl = new IntroductionImpl();
	  userImpl = new UserImpl();
	  profileImpl = new ProfileImpl();
	  photosImpl = new PhotosImpl();
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
	  List<QueryObject> obj = new ArrayList<>();
		QueryObject usernameObj = setData("beverly", "username");
		QueryObject passwordObj = setData("BEVlev13", "password");
		obj.add(usernameObj);
		obj.add(passwordObj);
	  UserModel data = (UserModel)DatabaseOperationDao.findByWhere(userImpl, obj);
	  if(data != null) {
		  System.out.println(String.format("Username: %s", data.getUsername()));
		  System.out.println(String.format("Password: %s", data.getPassword()));
	  } else {
		  System.out.println("object is null");
	  }
  }
  
  
  @Test
  public void findAllProfileImpl() {
	  ProfileModel temp = (ProfileModel) DatabaseOperationDao.findAll(profileImpl);
	  System.out.println(temp.getContacts().get(0).getContent());
  }
  
  @Test 
  public void findAllPhotosImpl() {
	  CommonListModel<ServicesModel> data = (CommonListModel<ServicesModel>) DatabaseOperationDao.findAll(photosImpl);
	  for(Iterator<ServicesModel> it = data.getListOfModel().iterator(); it.hasNext();) {
		  ServicesModel temp = it.next();
		  System.out.println(String.format("title: %s", temp.getTitle()));
		  System.out.println(String.format("description: %s", temp.getDescription()));
		  System.out.println(String.format("picture: %s", temp.getPicture()));
	  }
  }
  
  private QueryObject setData(String datum, String column) {
		QueryObject data = new QueryObject();
		data.setBolOpt(BoleanOperators.AND);
		data.setColumn(column);
		data.setOpt(Operations.EQ);
		data.setDatum(datum);
		return data;
	}

}
