package in.pentagon.studentapp.Console;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
		StudentDAOImpl sdao=new StudentDAOImpl();
		int choice=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("-----login page-------");
		System.out.println("enter email:");
		String email=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		Student s=sdao.getStudent(email, password);
		if(s!=null) {
			System.out.println("Login Successfully..Welcome "+s.getName());
			
			do {
				System.out.println("1. User Details");
				System.out.println("2. Update ACCOUNT");
				System.out.println("3. Reset password");
				System.out.println("4. Search USER");
				System.out.println("5. Goto Main menu");
				if(s.getId()==1) {
					System.out.println("6. View All The User");
					System.out.println("7. Delete User");
				}
				choice=sc.nextInt();
				switch(choice) {
				case 1:System.out.println(s.toString());
					break;
				case 2:Update.update(s);
					break;
				case 3:Password.forget();
					break;
				case 4:System.out.println("Enter user name to search");
					 String name=sc.next();
					ArrayList<Student> stdlist=sdao.getStudent(name);
						for(Student s2:stdlist) {
							System.out.println("===============");
							System.out.println(s2.getName());
							System.out.println(s2.getBranch());
							System.out.println("===============");
						}
					 break;
				case 5:System.out.println("Go To main ");
					break;
				case 6:ArrayList<Student> students = sdao.getStudent(s);
						for(Student s1:students) {
							System.out.println(s1);
						}
				
					break;
				case 7:System.out.println("ENter student id to be delete");
				  boolean res= sdao.deleteStudent(sc.nextInt());
				  if(res) {
					  System.out.println("delete user sucessfully");
				  }
				  else {
					  System.out.println("failed to delete");
				  }
					break;
				default:System.out.println("Invalide choice");
				break;
				}
			}while(choice!=5);
			
		}
		else {
			System.out.println("Failed to Login");
		}
		
	}

}
