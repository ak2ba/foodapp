package com.food.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOImp.UserDAOImp;
import com.food.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImp();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // In a real app, hash and check the password

        User user = userDAO.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Create a session and redirect to home page
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            response.sendRedirect("home");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}