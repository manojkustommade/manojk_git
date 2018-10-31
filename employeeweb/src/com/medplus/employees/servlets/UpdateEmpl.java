package com.medplus.employees.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employees.beans.Employee;
import com.medplus.employees.service.AdminService;
import com.medplus.employees.service.impl.AdminServiceImpl;
import com.medplus.employees.utils.DateParsing;

/**
 * Servlet implementation class UpdateEmpl
 */
@WebServlet("/UpdateEmpl")
public class UpdateEmpl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpl() {
        super();
        // TODO Auto-generated constructor stub
    }

	AdminService service=new AdminServiceImpl();
	Employee emp=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code=Integer.parseInt(request.getParameter("code"));
		emp=service.getEmployee(code);
		RequestDispatcher rd=request.getRequestDispatcher("UpdateEmpl.jsp");
		request.setAttribute("employee", emp);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int empcode=Integer.parseInt(request.getParameter("empcode"));
		String empname=request.getParameter("empname");
		String job=request.getParameter("job");
		double sal=Double.parseDouble(request.getParameter("salary"));
		String dob=request.getParameter("dateofbirth");
		
		Employee empls=new Employee();
		empls.setEmpcode(empcode);
		empls.setEmpname(empname);
		empls.setJob(job);
		empls.setSalary(sal);
		empls.setDateOfBirth(DateParsing.convertToUtilDate(dob));
		int rows=service.updateEmployee(empls);
		List<Employee> emplist=service.getEmpls();
		RequestDispatcher rd=request.getRequestDispatcher("UpdateAdminEmpl.jsp");
        request.setAttribute("emp", emplist);
		
		rd.forward(request, response);
	}
   
}
