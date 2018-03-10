package com.beverly.personal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.common.ConstInt;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.PhotosImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
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
		return false;
	}
	
	private CommonListModel<ServicesModel> getServices() {
		Retrieve photosImpl = new PhotosImpl();
		CommonListModel<ServicesModel> data = (CommonListModel<ServicesModel>) DatabaseOperationDao.findAll(photosImpl);
		return data;
	}
	
	
	

}
