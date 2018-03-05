package com.beverly.personal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beverly.personal.base.BaseServlet;
import com.beverly.personal.common.ConstInt;

@WebServlet("/personal/favorites")
public class FavoritesServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3841608026158461832L;

	@Override
	protected void customDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setNavActive(ConstInt.NAV_FAV);
		setView("/pages/favorites.jsp");
	}

	@Override
	protected boolean customDoPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return false;
	}
	
	

}
