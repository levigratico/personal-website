package com.beverly.personal.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.ConstInt;
import com.beverly.personal.common.ConstString;
import com.beverly.personal.dao.DatabaseOperationDao;
import com.beverly.personal.interactors.implementations.UserImpl;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.UserModel;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3831104757612979931L;
	
	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("isLogin", false);
		setNavActive(ConstInt.NAV_LOGIN);
	    setView("/pages/login.jsp");
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String) req.getParameter("inputUsername");
		String password = (String) req.getParameter("inputPassword");
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		Retrieve userImpl = new UserImpl();
		UserModel data = (UserModel)DatabaseOperationDao.findByWhere(userImpl, map);
		if(data != null) {
			HttpSession session = req.getSession();
			session.setAttribute("isLogin", true);
			resp.sendRedirect(String.format("%s/index", ConstString.BASEURL.getString()));
			return true;
		}	
		setNavActive(ConstInt.NAV_LOGIN);
		setView("/pages/login.jsp");
		return false;
	}
	
	

}
