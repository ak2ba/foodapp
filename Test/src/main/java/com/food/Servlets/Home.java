package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.RestaurantDAO;
import com.food.DAOImp.RestaurantDAOImp;
import com.food.model.Restaurant;

@WebServlet("/home")  // Mapping the servlet to the URL 'home'
public class Home extends HttpServlet {

    private RestaurantDAO restaurantDAO;

    @Override
    public void init() {
        // Initialize the DAO
        restaurantDAO = new RestaurantDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch list of restaurants
        List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();

        // Set the restaurant list as a request attribute
        request.setAttribute("restaurantList", restaurantList);
        
        System.out.println("asdfasdfg");

        // Forward to home.jsp
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.include(request, response);
    }
}