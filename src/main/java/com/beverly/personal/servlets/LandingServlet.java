package com.beverly.personal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.ConstInt;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.OrdersImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.OrdersModel;


@WebServlet("/personal/landing")
public class LandingServlet extends BaseServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = -420190356913594948L;


	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("model", getOrder(id));
		setNavActive(ConstInt.NAV_PHOTOS);
		setView("/pages/landingpage.jsp");
		
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	private OrdersModel getOrder(int id) {
		Retrieve retrieve = new OrdersImpl();
		return ((OrdersModel) DatabaseOperationDao.findById(retrieve, id));
	}

}
