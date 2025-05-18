package com.cdac.pages;
import static com.cdac.utils.DBUtils.closeConnection;
import static com.cdac.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;

import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value ="/login", loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init");
		try{//open cn n create dao instance
		openConnection();
		//create dao instance
		userDao = new UserDaoImpl();
		}catch(Exception e) {
			System.out.println(e);
			
			throw new ServletException("err in init",e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("in destroy");
		try{
			//clean up dao
			userDao.cleanUp();
			closeConnection();
		}catch(Exception e) {
			System.out.println("in destroy"+e);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set content type , get write , read request data, invoke do's method-signin.
		//1. set content type
		response.setContentType("text/html");
		//2.get write (pw) to send text resp
		try(PrintWriter pw = response.getWriter()){
			//3.read req parameters - email/em, password/pass
			String email =request.getParameter("em");
			String password =request.getParameter("pass");
			//4.login servlet => user dao's method
			User user =userDao.signIn(email,password);
			//5.null checking
			if(user == null) {
				//invalid login
				pw.print("<h5>Invalid Login,"+"Please<a href='login.html'>Retry</a><h5>");
			}else {
				//valid login 
				pw.print("<h5>Login Successful, Your Details"+user+"</h5>");
			}
			if(user.getUserRole().equals("admin")){
				response.sendRedirect("admin_dashboard");
				
			}else {
				//voter login status
				if(user.isStatus())
					response.sendRedirect("logout");
				else
					response.sendRedirect("candidate_list");
			}
		}catch(Exception e) {
			throw new ServletException("err in do-post", e);
		}
	}

}
