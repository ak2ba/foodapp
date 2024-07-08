package com.food.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuItem
 */
@WebServlet("/menu")
public class MenuItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Menu");
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		System.out.println(restaurantId);
		
		/*
		 * 
		 * getMenuByRestId(int restaurantId)
		 * {
		 * 
		 * }
		 * 
		 * set using Request
		 * 
		 * requestDispatcher ill send data to menu.jsp
		 * 
		 * 
		 * 
		 */
		
	}

}

















