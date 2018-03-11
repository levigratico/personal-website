package com.beverly.personal.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.common.ConstInt;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.PhotosImpl;
import com.beverly.personal.interactors.interfaces.Insert;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.ServicesModel;

@WebServlet("/personal/photos")
public class PhotosServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3461303828435144485L;

	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("model", getServices());
		setNavActive(ConstInt.NAV_PHOTOS);
		setView("/pages/photos.jsp");
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//inserting here
		if(insertData(prepareObject(req))) {
			req.setAttribute("orderid", DatabaseOperationDao.selectLastIdInserted("orders_tbl"));
			setView("/pages/redirect.jsp");
			return false;
		}
		resp.setContentType("text/html");
		resp.getWriter().println("Error");
		return false;
	}
	
	private CommonListModel<ServicesModel> getServices() {
		Retrieve photosImpl = new PhotosImpl();
		CommonListModel<ServicesModel> data = (CommonListModel<ServicesModel>) DatabaseOperationDao.findAll(photosImpl);
		return data;
	}
	
	
	private List<InsertObject> prepareObject(HttpServletRequest req) {
		List<InsertObject> obj = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		String[] columns = { "name", "address", "email", "contact", "service_id", "status", "date"  };
		map.put("name", String.format("%s, %s %s", req.getParameter("lastname"), req.getParameter("firstname"), req.getParameter("middlename")));
		map.put("address", String.format("%s %s %s %s %s ", req.getParameter("address"), req.getParameter("street"), req.getParameter("city"), req.getParameter("state"), req.getParameter("zipcode")));
		map.put("email", req.getParameter("email"));
		map.put("contact", req.getParameter("contact"));
		map.put("service_id", Integer.parseInt(req.getParameter("packageId")));
		map.put("status", 0);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();
		map.put("date", formatter.format(date));
		
		for (Map.Entry<String, Object> entry : map.entrySet())
		{
			InsertObject temp = new InsertObject(entry.getKey(), entry.getValue());
			obj.add(temp);
		}
		return obj;
	}
	
	
	private boolean insertData(List<InsertObject> obj) {
		Insert photosInsertImpl = new PhotosImpl();
		return DatabaseOperationDao.insertData(photosInsertImpl, obj, "orders_tbl");
	}
}
