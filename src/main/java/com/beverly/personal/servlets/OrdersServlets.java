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
import com.beverly.personal.interactors.implementations.OrdersImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.OrdersModel;


@WebServlet("/personal/orders")
public class OrdersServlets extends BaseServlet {

	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("model", getOrders());
		setNavActive(ConstInt.NAV_FAV);
		setView("/pages/orders.jsp");
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		return false;
	}
	
	
	private CommonListModel<OrdersModel> getOrders() {
		Retrieve ordersImpl = new OrdersImpl();
		return (CommonListModel<OrdersModel>) DatabaseOperationDao.findAll(ordersImpl);
	}

}
