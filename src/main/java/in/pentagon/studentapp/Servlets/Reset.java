package in.pentagon.studentapp.Servlets;

import java.io.IOException;

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
@WebServlet("/reset")
public class Reset extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("student");
		StudentDAO sdao=new StudentDAOImpl();
		if(s!=null) {
			if(s.getMail().equals(req.getParameter("mail"))&& s.getPhone()==Long.parseLong(req.getParameter("phone"))) {
				if(req.getParameter("pass").equals(req.getParameter("conf"))) {
					s.setPassword(req.getParameter("pass"));
					boolean res=sdao.updateStudent(s);
					if(res) {
						req.setAttribute("success", "password reset successfully");
						RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
						rd.forward(req, resp);
					}
					else {
						req.setAttribute("error", "failed to update ");
						RequestDispatcher rd=req.getRequestDispatcher("reset.jsp");
						rd.forward(req, resp);
					}
					
				}
				else {
					req.setAttribute("error", "password mismatch ");
					RequestDispatcher rd=req.getRequestDispatcher("reset.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error", "something went wrong ");
				RequestDispatcher rd=req.getRequestDispatcher("reset.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error", "session expired ");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
