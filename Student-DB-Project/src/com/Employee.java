package com;

public class Employee {
	String id;
	String name;
	static int count=101;
	Employee(String name)
	{
		this.id="jsp"+count;
		this.name=name;
		count++;
	}
	

	public static void main(String[] args) {
	Employee e1=new Employee("tom");	
	System.out.println("id:"+e1.id+" name: "+e1.name);
	
	Employee e2=new Employee("jerry");	
	System.out.println("id:"+e2.id+" name:"+e2.name);
	
	

	}

}
