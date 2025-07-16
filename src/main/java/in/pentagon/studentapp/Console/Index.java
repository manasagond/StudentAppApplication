package in.pentagon.studentapp.Console;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("welcome to student app");
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. FORGET PASSWORD");
			System.out.println("4. EXIT");
			choice=sc.nextInt();
			switch(choice) {
			case 1:SignUp.signup();
				break;
			case 2:Login.login();
				break;
			case 3:Password.forget();
				break;
			case 4:
				System.out.println("Thank you");
				break;
			default:System.out.println("invalid choice");
			    break;
			}
		}while(choice!=4);

	}

}
