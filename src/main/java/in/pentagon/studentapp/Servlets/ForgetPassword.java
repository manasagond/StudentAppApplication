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
@WebServlet("/forgetpassword")

public class ForgetPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		StudentDAO sdao=new StudentDAOImpl();
		Student s=sdao.getStudent((Long.parseLong(req.getParameter("phone"))),req.getParameter("email"));
		if(s!=null) {
			if(req.getParameter("pass").equals(req.getParameter("conf"))) {
				s.setPassword(req.getParameter("pass"));
				
				boolean res=sdao.updateStudent(s);
				if(res) {
					//out.println("<h1> password update successfully</h1>");
					req.setAttribute("success","Password update successfully");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
				else {
					//out.println("<h1>Failed to update</h2>");
					req.setAttribute("error","failed to update password");
					RequestDispatcher rd=req.getRequestDispatcher("forgerpassword.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error","password mismatch");
				RequestDispatcher rd=req.getRequestDispatcher("forgetpassword.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error","data not found");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}
		
	}

}
