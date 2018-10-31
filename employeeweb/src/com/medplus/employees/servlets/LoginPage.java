package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		HttpSession session=request.getSession();
		if(username.equals("admin")){
			if(password.equals("admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
				session.setAttribute("logintype", "admin");
				session.setAttribute("user", username);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
				request.setAttribute("error", "Password not matched");
				rd.forward(request, response);
			}
				
		}
		else {
			if(password.equals("123")) {
				RequestDispatcher rd=request.getRequestDispatcher("UserHomePage.jsp");
				session.setAttribute("logintype", "user");
				session.setAttribute("user", username);
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
				request.setAttribute("error", "Password not matched");
				rd.forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
