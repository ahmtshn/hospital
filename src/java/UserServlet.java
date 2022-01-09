/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author ahmetsahin
 */
public class UserServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String action = request.getServletPath();
	
	switch (action) {
	    case "/login": {
		try {
		    loginUser(request, response);
		} catch (SQLException ex) {
		    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	    break;
	    case "/profile": {
		try {
		    getProfile(request, response);
		} catch (SQLException ex) {
		    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	    break;
	    case "/user-update": {
		try {
		    updateUser(request, response);
		} catch (SQLException ex) {
		    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	    break;
	    
	    case "/signup": {
		try {
		    createUser(request, response);
		} catch (SQLException ex) {
		    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	    break;
	    
	    case "/personel-list": {
		try {
		    getPersonelList(request, response);
		} catch (SQLException ex) {
		    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	    break;
	    
	    case "/signout":
		signout(request, response);
		break;
	    
	    default:
		break;
	}
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	this.doGet(request, response);
    }
    
    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
	
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String userType = request.getParameter("userType");
	String tckn = request.getParameter("tckn");
	String remember = request.getParameter("remember");
	
	User user = new User(name, password, userType, tckn);
	
	UserDao ud = new UserDao();
	User responseUser = ud.getUser(user);
	if (responseUser.getName() != null) {
	    HttpSession session = request.getSession();
	    session.setAttribute("currentUser", responseUser);
	    
	    Cookie userTypeCookie = new Cookie("userType", userType);
	    Cookie rememberCookie = new Cookie("remember", remember);
	    userTypeCookie.setMaxAge(300000);
	    response.addCookie(userTypeCookie);
	    if (remember != null) {
		response.addCookie(rememberCookie);
	    }
	    
	    response.sendRedirect("/hospital/list");
	} else {
	    //response.sendRedirect("/hastane/personel-home.jsp");
	}
	
    }
    
    private void getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
	dispatcher.forward(request, response);
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
	HttpSession session = request.getSession();
	User currentUser = (User) session.getAttribute("currentUser");
	
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String userType = currentUser.getUserType();
	String tckn = currentUser.getTckn();
	
	User user = new User(name, password, userType, tckn);
	
	UserDao ud = new UserDao();
	boolean success = ud.updateUser(user);
	
	if (success) {
	    
	    session.setAttribute("currentUser", user);
	}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
	dispatcher.forward(request, response);
    }
    
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
	HttpSession session = request.getSession();
	
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String userType = request.getParameter("userType");
	String tckn = request.getParameter("tckn");
	
	User user = new User(name, password, userType, tckn);
	
	UserDao ud = new UserDao();
	boolean success = ud.insertUser(user);
	
	if (success) {
	    session.setAttribute("currentUser", user);
	}
	
	response.sendRedirect("login.jsp");
	
    }
    
    private void getPersonelList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
	
	UserDao ud = new UserDao();
	List<User> list = ud.getPersonel();
	request.setAttribute("personelList", list);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
	dispatcher.forward(request, response);
	
    }
    
    private void signout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	Cookie cookie = new Cookie("remember", null);
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	
	response.sendRedirect("index.jsp");
    }
    
}
