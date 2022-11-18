package com.springorm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springorm/config.xml");
		StudentDao student = (StudentDao) context.getBean("studentDao");
		Student st = new Student();

		int choice;
		String name;
		String city;
		int id1;

		System.out.println("Press 1 to Add Record");
		System.out.println("Press 2 to show all Record");
		System.out.println("Press 3 to Delete Record");
		System.out.println("Press 4 to Update Record");
		System.out.println("Press 5 to specific Record");

		Scanner sc = new Scanner(System.in);
		char ans = 'Y';
		while (ans == 'Y') {
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter Student Name");
				name = sc.next();
				System.out.println("Enter Student City");
				city = sc.next();
				st.setStudent_name(name);
				st.setStudent_city(city);
				int id = student.insert(st);
				System.out.println(id + "Inserted Successfully");
				break;

			case 2:
				List<Student> l = student.getAllRecord();
				for (Student s : l) {
					System.out.println(s.getStudent_id() + "\t" + s.getStudent_city() + "\t" + s.getStudent_name());
				}
				break;
				
			case 3:
				System.out.println("Enter Student id");
				id1 = sc.nextInt();
				student.deleteRecord(id1);
				System.out.println("Record Deleted Successfully");
				break;
				
			case 4:
				System.out.println("Enter Student id");
				id1 = sc.nextInt();
				System.out.println("Enter Student Name");
				name = sc.next();
				System.out.println("Enter Student City");
				city = sc.next();
				student.updateRecord(id1, name, city);
				System.out.println("Record Updated Successfully....");
				break;
				
			case 5:
				System.out.println("Enter Student id..");
				id1 = sc.nextInt();
				Student s = student.getSingleRecord(id1);
				System.out.println(s.getStudent_id() + "\t" + s.getStudent_city() + "\t" + s.getStudent_name());
				break;

			default:
				System.out.println("Wrong Choice");
			}
			System.out.println("Do you want to Continue....");
			ans = sc.next().charAt(0);
		}

	}
}
