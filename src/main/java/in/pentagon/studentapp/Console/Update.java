package in.pentagon.studentapp.Console;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {
public static void update(Student s) {
	StudentDAO sdao=new StudentDAOImpl();
	int choice=0;
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("1. Update a name");
		System.out.println("2. Update a Phone");
		System.out.println("3. Update a mail");
		System.out.println("4. Update Branch");
		System.out.println("5. Update Location");
		System.out.println("6. Back");
		choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.println("Enter new name");
			s.setName(sc.next());
			break;
		case 2:System.out.println("Enter new phone");
			s.setPhone(sc.nextLong());
			break;
		case 3:System.out.println("Enter new mail id");
			s.setMail(sc.next());
			break;
		case 4:System.out.println("enter new branch");
			s.setBranch(sc.next());
			break;
		case 5:System.out.println("Enter new Location");
			s.setLoc(sc.next());
			break;
		case 6:System.out.println("back to menu");
		   break;
		default:System.out.println("invalide choice");
			break;
		}
	}while(choice!=6);
	 boolean res= sdao.updateStudent(s);
	 if(res) {
		 System.out.println("Data updated successfully");
	 }
	 else {
		 System.out.println("failed to update data");
	 }
}
}
