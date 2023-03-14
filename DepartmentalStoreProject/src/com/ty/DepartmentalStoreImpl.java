package com.ty;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreImpl implements DepartmentalStore {
	
	//Key ->Product Id->Integer      Value ->Product Instance->Product
	Map<Integer,Product> db=new LinkedHashMap<Integer,Product>();
	Scanner sc=new Scanner(System.in);
	int totalBill=0;
	

	@Override
	public void addProduct() {
		db.put(1, new Product("Chockalate",10,5));
		db.put(2, new Product("Biscuts",20,10));
		db.put(3, new Product("IceCream",30,20));
	}

	@Override
	public void displayProduct() {
		Set<Integer> keys=db.keySet();
		for(Integer key:keys)
		{
			Product p=db.get(key);	//1,2,3
			System.out.println("Enter "+key+" to order "+p.getName());
			System.out.println("Available Queantity "+p.getQuantity());
			System.out.println("Cost Rs "+p.getCost());
			System.out.println("--------------------------------------");
		}
	}

	@Override
	public void buyProduct() {
		System.out.println("Enter a choice"); //choice ->key
		int choice=sc.nextInt();
		
		//get() return null, when the key(choice) is  ot present
		Product p=db.get(choice);// getting the product based on the product
		
		if(p!=null)
		{
			System.out.println("Buyong "+p.getName());
			System.out.println("Enter the quantity");
			int quantity=sc.nextInt();
			if(quantity<=p.getQuantity())
			{
				//calculating the cuurent product cost
				int productcost=quantity*p.getCost();
				
				//adding current productcost into total bill
				totalBill=totalBill+productcost; //totalBill +=productcost
				
				//updating new quantity
				p.setQuantity(p.getQuantity()-quantity);
				
				System.out.println("Ordered "+quantity+" "+p.getName());
				System.out.println("Current product cost is Rs."+productcost);
				System.out.println("Total bill as of now Rs."+totalBill);
			}
			else
			{
				try
				{
					String message="Invalid quantity "+p.getQuantity()+" not available";
					throw new InvalidQuantityException(message);
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
				String message="Invalic choice, Kindly enter a valid choice";
				throw new InvalidChoiceException(message);
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
	}

	@Override
	public void checkout() {
		System.out.println("The total bill is "+totalBill);
		System.out.println("Thank You For Shopping !");
		
	}
	

}
