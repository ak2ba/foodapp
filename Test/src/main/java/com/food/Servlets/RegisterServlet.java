package com.food.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDAO;
import com.food.DAOImp.UserDAOImp;
import com.food.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect user data from request
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Hash the password for real application
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // Create User object and save using DAO
        User newUser = new User(0, username, password, email, address, "Customer");
        userDAO.addUser(newUser);

        response.sendRedirect("login.jsp");
    }
}