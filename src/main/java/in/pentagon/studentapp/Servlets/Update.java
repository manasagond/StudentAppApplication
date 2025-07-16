package in.pentagon.studentapp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.Session;

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
@WebServlet("/updateAccount")
public class Update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		Student s=(Student) session.getAttribute("student");
		//s.setId(Integer.parseInt(req.getParameter("id"))); 
		
		if(s!=null) {
			s.setName(req.getParameter("name"));
			s.setPhone(Long.parseLong(req.getParameter("phone")));
			s.setMail(req.getParameter("mail"));
			s.setBranch(req.getParameter("branch"));
			s.setLoc(req.getParameter("location"));
			boolean res=sdao.updateStudent(s);
			if(res) {
				req.setAttribute("success", "data update successfully");
				RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("error", "failed to update data");
				RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error", "session expired");
			RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
			rd.forward(req, resp);
		}
		
		
	}

}
