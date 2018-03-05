package com.beverly.personal.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beverly.personal.common.ConstInt;
import com.beverly.personal.common.ConstString;

public abstract class BaseServlet extends HttpServlet {
	
	private String BASE_URL = ConstString.BASEURL.getString();
	private int navActive;
	private String view = String.format("%s%s", ConstString.BASEURL.getString(), "/index");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("isLogin") != null) {
			session.setAttribute("isLogin", ((boolean)session.getAttribute("isLogin")));
		} else {
			session.setAttribute("isLogin", false);
		}
		customDoGet(req, resp);
		setAll(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!customDoPost(req, resp)) {
			setAll(req, resp);
		}
	}
	
	
	protected abstract void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	protected abstract boolean customDoPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	protected void setNavActive(ConstInt nav) {
		navActive = nav.getNumber();
	}
	
	protected void setView(String pathOfView) {
		view = pathOfView;
	}
	
	private void setAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("base_url", BASE_URL);
		req.setAttribute("active", navActive);
		RequestDispatcher viewDispatcher = req.getRequestDispatcher(view);
		viewDispatcher.forward(req, resp);
	}
}
