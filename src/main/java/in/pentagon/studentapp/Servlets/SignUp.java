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

@WebServlet("/signup")

public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student();
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out = resp.getWriter();
		//collecting the data
		s.setName(req.getParameter("name"));
		
		//String phone=req.getParameter("phone");
		//Long phone_no=Long.parseLong(phone);
		//s.setPhone(phone_no);
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("location"));
		if(req.getParameter("pass").equals(req.getParameter("conf"))) {
			s.setPassword(req.getParameter("pass"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data added successfully!</h1>");
				req.setAttribute("success", "Data added successfully");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				
			}
			else {
				//out.println("<h1>Failed to add the data!</h1>");
				req.setAttribute("error", "Failed to add Data");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error", "Password mismatch");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}
		
	}
}
