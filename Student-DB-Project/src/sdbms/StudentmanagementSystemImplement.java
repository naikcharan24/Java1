package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;
import exception.InvalidChoiceException;
import exception.StudentNotFoundException;

public class StudentmanagementSystemImplement implements StudentManagementSystem
{
	// create Scanner class to accept the inputs
	//store it in db here db is linkedHasMap
	Scanner sc=new Scanner(System.in);
	Map<String,Student>db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent() {
		//Accept age,name,marks;
		//add Student instance in DB(MAP)-> put();
		// print Student id
		System.out.println("enter Student age");
		int age=sc.nextInt();
		System.out.println("enter student name");
		String name=sc.next();
		System.out.println("enter student marks");
		int marks=sc.nextInt();
		Student s1=new Student(age,name,marks);
		db.put(s1.getId(), s1);
		System.out.println("student record inserted succeussfully");
		System.out.println("student Id is"+s1.getId());

	}

	@Override
	public void displayStudent() {
		//Accept the Id from user jsp101 JSP101 Jsp101
		//toUpperCase()
		//check if the Id is present or not
		// if id is present-> get value(student object)-> getAge(),getName()..
		//else
		System.out.println("enter student id");
		String id=sc.next();// String id=sc.next().toUpperCase();
		id.toUpperCase();
		if(db.containsKey(id))// getting student object
		{
			Student std=db.get(id);
			System.out.println("student details are fallows");
			System.out.println("student Id:"+std.getId());
			System.out.println("Student Age:"+std.getage());
			System.out.println("Student Name:"+std.getName());
			System.out.println("Student Marks:"+std.getMarks());
		}
		else
		{
			try
			{
				String message="student with the Id:"+id+" is not Found!!";
				throw new StudentNotFoundException("Student Not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() {
		// map to Set help of keySet()
		// Traversing by foreach()
		// db.get(key)-> toString() ->print
		if(db.size()!=0)
		{
			System.out.println("student details are as Follows");
			System.out.println("---------------------------");
			Set<String>keys=db.keySet();// JSP101 JSP102 JSP103
			for(String key:keys)
			{
				Student std=db.get(key);
				System.out.println(std);////System.out.println(db.get(key));

			}
		}
		else
		{
			try
			{
				String message="student database is empty, nothing to display";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void removeStudent() {
		//Accept the student id and convert into Uppercase
		// check if id is present or not 
		// if id is present =db.remove();
		// else
		System.out.println("enter Id:");
		String id=sc.next();// String id=sc.next().toUpperCase();
		id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("student record found!");
			System.out.println(db.get(id));// getting and printing student object
			Student std=db.remove(id);// removing student object
			System.out.println("student record deleted succussfully");
		}
		else
		{
			try
			{
				String message="student with the Id:"+id+" is not Found!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllStudents() {
		if(db.size()!=0)
		{
			System.out.println("Available student recors:"+db.size());
			db.clear();
			System.out.println("All the student record deleted succussfully");
		}
		else
		{
			try
			{
				String message="student database is empty, nothing to remove";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}



	@Override
	public void updateStudent() {
		//Accept the Id from user jsp101 JSP101 Jsp101
		//toUpperCase()
		//check if the Id is present or not
		// if id is present-> get value(student object)-> getAge(),getName()..
		// display 1:update age 2: 3:
		// switch case 1 2 3 -> default -> ICE
		// else invoke StudentNotFoundException
		System.out.println("enter student id");
		String id=sc.next();
		id.toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("1:Update Age\n2:UpdateName\n3:Update Marks");
			System.out.println("enter choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("enetr Age");
				int age=sc.nextInt();
				std.setAge(age); // std.setAge(sc.nextInt());
				System.out.println("age Updated succussfully");
				break;
			case 2:
				System.out.println("enter Name");
				String name=sc.next();
				std.setName(name);
				System.out.println("name Updated succussfully");
				break;
			case 3:
				System.out.println("enetr marks");
				int marks=sc.nextInt();
				std.setMarks(marks);
				System.out.println("marks updated succussfully");
				break;
			
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

		}
		else
		{
			try
			{
				String message="student with the Id:"+id+" is not Found!!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudents() {
		System.out.println(" No of student Records:"+db.size());

	}

	@Override
	public void sortStudents() {
		//List & ArrayList -> <Student>
		//Map into Set -> keySet() ->keys
		//traverse keys using for each loop
		//get the values(student object) & add it into ArrayList
		if(db.size()>=2)
		{
			List<Student> list=new ArrayList<Student>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));		//getting and adding student object in AL
			}
			System.out.println("1:Sort Student by ID\n2:Sort Student by age");
			System.out.println("3:Sort Student by name\n4:Sort Student by Marks");
			System.out.println("Enter a choice:");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				Collections.sort(list,new SortStudentById());
				display(list);
				break;
			case 2:
				Collections.sort(list,new SortStudentByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			case 4:
				Collections.sort(list,new SortStudentByMarks());
				display(list);
				break;
			default:
				try
				{
					String msg="Invalid choice..Kindly enter a valid choice!";
					throw new InvalidChoiceException(msg);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{
				String msg="No suficient student Record to sort";
				throw new StudentNotFoundException(msg);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static void display(List<Student>list)
	{
		for(Student s: list)
		{
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2)
		{
			List<Student> list=new ArrayList<Student>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));		//getting and adding student object in AL
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(list.size()-1));
		}
		else
		{
			try
			{
				String msg="No suficient student Record to sort";
				throw new StudentNotFoundException(msg);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2)
		{
			List<Student> list=new ArrayList<Student>();
			Set<String> keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));		//getting and adding student object in AL
			}
			Collections.sort(list, new SortStudentByMarks());
			System.out.println(list.get(0));
		}
		else
		{
			try
			{
				String msg="No suficient student Record to sort";
				throw new StudentNotFoundException(msg);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}