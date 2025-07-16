package in.pentagon.studentapp.Console;

import java.sql.PreparedStatement;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class SignUp {
	
	public static void signup() {
		//PreparedStatement ps=null;
		StudentDAO sdao=new StudentDAOImpl();
		Scanner sc=new Scanner(System.in);
		Student s=new Student();
		System.out.println("----Welcome to signup page------");
		System.out.println("enter name:");
		s.setName(sc.next());
		System.out.println("enter phone:");
		s.setPhone(sc.nextLong());
		System.out.println("enter mail:");
		s.setMail(sc.next());
		System.out.println("enter branch:");
		s.setBranch(sc.next());
		System.out.println("enter location");
		s.setLoc(sc.next());
		System.out.println("set password");
		String password=sc.next();
		System.out.println("confirm password");
		String confirmpass=sc.next();
		if(password.equals(confirmpass)) {
			s.setPassword(password);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("data loaded successfully");
			}
			else {
				System.out.println("failed to load data");
			}
			
		}
		else {
			System.out.println("password mismatch");
		}
		
		
	
		
		
	}

}
