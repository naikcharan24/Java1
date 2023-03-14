package sdbms;

import java.util.Scanner;

import exception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("welcom to student database project");
		System.out.println("---------------------------------");
		Scanner scan=new Scanner(System.in);
		StudentManagementSystem sm=new StudentmanagementSystemImplement();
		while(true)
		{
			System.out.println("1:addStudent\n2:displayStudent");
			System.out.println("3:displayAllStudents\n4:removeStudent\n5:removeAllStudents");
			System.out.println("6:updateStudent\n7:countStudents\n8:sortStudents");
			System.out.println("9:getStudentWithHighestMarks\n10:getStudentWithLowestMarks");
			
			System.out.println("enter choice");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				sm.addStudent();
				break;
			case 2:
				sm.displayStudent();
				break;
			case 3:
				sm.displayAllStudents();
				break;
			case 4:
				sm.removeStudent();
				break;
			case 5:
				sm.removeAllStudents();
				break;
			case 6:
				sm.updateStudent();
				break;
			case 7:
				sm.countStudents();
				break;
			case 8:
				sm.sortStudents();
				break;
			case 9:
				sm.getStudentWithHighestMarks();
				break;
			case 10:
				sm.getStudentWithLowestMarks();
				break;
			case 11:
				System.exit(0);
			default:
				try
				{
					throw new InvalidChoiceException("Invalid choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.println("----------------------");
		}
	}
}
