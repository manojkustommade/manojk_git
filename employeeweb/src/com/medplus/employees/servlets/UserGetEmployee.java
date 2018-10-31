package com.medplus.employees.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.service.UserService;
import com.medplus.employees.service.impl.userServiceImpl;

/**
 * Servlet implementation class UserPage
 */
@WebServlet("/UserGetEmployee")
public class UserGetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserGetEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("sdhkjsda");
		UserService us=new userServiceImpl();
		int ecode=Integer.parseInt(request.getParameter("empcode"));
		Employee emp=us.getEmployee(ecode);
		RequestDispatcher rd=request.getRequestDispatcher("UserGetEmployee.jsp");
		request.setAttribute("employee", emp);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
