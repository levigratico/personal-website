package com.beverly.personal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.ConstInt;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.IntroductionImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.IntroductionModel;

@WebServlet("/index")
public class HomeServlet extends BaseServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("model", retrieveData());
		setNavActive(ConstInt.NAV_HOME);
		setView("/index.jsp");
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return false;
	}
	
	
	private IntroductionModel retrieveData() {
		Retrieve retrieve = new IntroductionImpl();
		IntroductionModel rs = (IntroductionModel)DatabaseOperationDao.findAll(retrieve);
		return rs;
	}
	
	
	
}
