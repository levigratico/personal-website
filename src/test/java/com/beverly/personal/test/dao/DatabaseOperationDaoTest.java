package com.beverly.personal.test.dao;

import static org.junit.Assert.assertTrue;

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
import com.beverly.personal.interactors.implementations.OrdersImpl;
import com.beverly.personal.interactors.implementations.PhotosImpl;
import com.beverly.personal.interactors.implementations.ProfileImpl;
import com.beverly.personal.interactors.implementations.UserImpl;
import com.beverly.personal.interactors.interfaces.Insert;
import com.beverly.personal.interactors.interfaces.Manipulate;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.IntroductionModel;
import com.beverly.personal.model.OrdersModel;
import com.beverly.personal.model.Paragraph;
import com.beverly.personal.model.ProfileModel;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.ServicesCollection;
import com.beverly.personal.model.ServicesModel;
import com.beverly.personal.model.TableWithId;
import com.beverly.personal.model.UserModel;
import com.beverly.personal.util.SQLBuilder;

public class DatabaseOperationDaoTest {
	
   private Retrieve introductionImpl;	
   private Retrieve userImpl;
   private Retrieve profileImpl;
   private Retrieve photosImpl;
   private Retrieve ordersImpl;
   private Manipulate introductionImplManipulate;
   
   private Insert photosInsertImpl;
	
  @Before
  public void setup() {
	  introductionImpl = new IntroductionImpl();
	  userImpl = new UserImpl();
	  profileImpl = new ProfileImpl();
	  photosImpl = new PhotosImpl();
	  photosInsertImpl = new PhotosImpl();
	  ordersImpl = new OrdersImpl();
	  introductionImplManipulate = new IntroductionImpl();
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
  
  @Test
  public void findWherePhotosImpl() {
	  List<QueryObject> obj = new ArrayList<>();
	  QueryObject dataObj = setData(1, "a.service_id");
	  obj.add(dataObj);
	  CommonListModel<ServicesCollection> data = (CommonListModel<ServicesCollection>) DatabaseOperationDao.findByWhere(photosImpl, obj);
	  for(Iterator<ServicesCollection> it = data.getListOfModel().iterator(); it.hasNext();) {
		  ServicesCollection temp = it.next();
		  System.out.println(String.format("title: %s", temp.getServiceTitle()));
		  System.out.println(String.format("description: %s", temp.getServiceDescription()));
		  System.out.println(String.format("picture: %s", temp.getPicture()));
		  System.out.println(String.format("caption: %s", temp.getCaption()));
	  }
  }
  
  
  @Test
  public void insertPhotosImpl() {
	  List<InsertObject> obj = new ArrayList<>();
	  obj.add(new InsertObject("username", "levigratico"));
	  obj.add(new InsertObject("password", "levigratico"));
	  boolean test = DatabaseOperationDao.insertData(photosInsertImpl, obj, "user_tbl");
	  System.out.println("id: " + DatabaseOperationDao.selectLastIdInserted("user_tbl"));
	  assertTrue(test);
  }
  
  @Test
  public void testRet() {
	  Retrieve retrieve = new OrdersImpl();
	 OrdersModel model = ((OrdersModel) DatabaseOperationDao.findById(retrieve, 1));
  }
  
  
  @Test 
  public void findAllOrdersImpl() {
	  CommonListModel<OrdersModel> temp = (CommonListModel<OrdersModel>) DatabaseOperationDao.findAll(ordersImpl);
	  for(Iterator<OrdersModel> datum = temp.getListOfModel().iterator(); datum.hasNext();) {
		  OrdersModel tempData = datum.next();
		  System.out.println(String.format("%s", tempData.getAddress()));
		  System.out.println(String.format("%s", tempData.getTitle()));
		  
	  }
  }
  
  @Test
  public void updateByIdIntroductionImplTest() {
	  List<InsertObject> listInsertObject = new ArrayList<>();
	  TableWithId tblid = new TableWithId();
	  tblid.setId(3);
	  tblid.setTable("introduction_tbl");
	  InsertObject obj = new InsertObject("content", "I think it is very important to make a website compatible with all modern devices, like phones and tabltes");
	  listInsertObject.add(obj);
	  DatabaseOperationDao.updateById(introductionImplManipulate, listInsertObject, tblid);
		
  }
  
  private QueryObject setData(Object datum, String column) {
		QueryObject data = new QueryObject();
		data.setBolOpt(BoleanOperators.AND);
		data.setColumn(column);
		data.setOpt(Operations.EQ);
		data.setDatum(datum);
		return data;
	}
  

}
