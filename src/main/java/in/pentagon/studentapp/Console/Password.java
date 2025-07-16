package in.pentagon.studentapp.Console;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
 public static void forget() {
	 Scanner sc=new Scanner(System.in);
	 StudentDAO sdao=new StudentDAOImpl();
	 System.out.println("Enter phone number:");
	 long phone=sc.nextLong();
	 System.out.println("ENter email id:");
	 String mail=sc.next();
	 Student s=sdao.getStudent(phone, mail);
	 if(s!=null) {
		 System.out.println("Enter new password");
		 String pass=sc.next();
		 System.out.println("Enter confirm password");
		 String confirm=sc.next();
		 if(pass.equals(confirm)) {
			 s.setPassword(pass);
			 boolean res=sdao.updateStudent(s);
			 if(res) {
				 System.out.println("password updated");
			 }
			 else {
				 System.out.println("failed to update");
			 }
		 }
		 else {
			 System.out.println("password mismatch");
		 }
	 }
	 else {
		 System.out.println("falied to update ");
	 }
	 
	 
 }

}
