package in.pentagon.studentapp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")

public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		StudentDAO sdao=new StudentDAOImpl();
		HttpSession session=req.getSession();
		Student s=sdao.getStudent(req.getParameter("mail"), req.getParameter("pass"));
		if(s!=null) {
			//out.println("<h1>Login Successfully  ...Welcome</h1>");
			session.setAttribute("student", s);
			req.setAttribute("success","login successfully");
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
			
		}
		else {
			req.setAttribute("error","Failed to login!!!");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
