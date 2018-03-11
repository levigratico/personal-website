package com.beverly.personal.servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.BoleanOperators;
import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.common.ConstInt;
import com.beverly.personal.common.ConstString;
import com.beverly.personal.common.Operations;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.PhotosImpl;
import com.beverly.personal.interactors.interfaces.Insert;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.ServicesCollection;

@WebServlet("/pages/services/collections")
@MultipartConfig
public class CollectionsServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3642932853075747812L;

	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("model", getCollections(Integer.parseInt(req.getParameter("id"))));
		setNavActive(ConstInt.NAV_PHOTOS);
		setView("/pages/collections.jsp");
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(insertData(prepareObject(req))) {
		}
		 resp.sendRedirect(String.format("%s/pages/services/collections?id=%s", ConstString.BASEURL.getString(), req.getParameter("serviceid")));
		 return true;
	}
	
	private CommonListModel<ServicesCollection> getCollections(int id) {
		Retrieve photosImpl = new PhotosImpl();
		List<QueryObject> obj = new ArrayList<>();
		QueryObject dataObj = setData(id, "a.service_id");
		obj.add(dataObj);
		CommonListModel<ServicesCollection> data = (CommonListModel<ServicesCollection>) DatabaseOperationDao.findByWhere(photosImpl, obj);
		return data;
	}
	
	private QueryObject setData(Object datum, String column) {
		QueryObject data = new QueryObject();
		data.setBolOpt(BoleanOperators.AND);
		data.setColumn(column);
		data.setOpt(Operations.EQ);
		data.setDatum(datum);
		return data;
	}
	
	private File prepareFileToUpload(String filename) {
		String relativeWebPath = "/src/main/webapp/resources/images";
		String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
		File file = new File(absoluteDiskPath, filename);
		return file;
	}
	
	
	private boolean insertData(List<InsertObject> obj) {
		Insert photosInsertImpl = new PhotosImpl();
		return DatabaseOperationDao.insertData(photosInsertImpl, obj, "photos_tbl");
	}
	
	private List<InsertObject> prepareObject(HttpServletRequest req) {
		List<InsertObject> obj = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("caption", req.getParameter("caption"));
		map.put("picture", req.getParameter("filename"));
		map.put("service_id", req.getParameter("serviceid"));
		
		for (Map.Entry<String, Object> entry : map.entrySet())
		{
			InsertObject temp = new InsertObject(entry.getKey(), entry.getValue());
			obj.add(temp);
		}
		return obj;
	}
	
	
	
	

}
