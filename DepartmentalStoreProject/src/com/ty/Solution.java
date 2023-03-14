package com.ty;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		System.out.println("WELLCOME TO OUR DEPARTMENTAL STORE");
		System.out.println("===================================");
		
		// upcasting to achive abstraction
		DepartmentalStore store=new DepartmentalStoreImpl();
		Scanner sc=new Scanner(System.in);
		
		store.addProduct();//add only once
		int choice=1;
		while(choice==1)
		{
			store.displayProduct();
			store.buyProduct();
			System.out.println("Enter 1 to continue or any another num to checkout");
			choice=sc.nextInt();
		}
		store.checkout();//checking out only once
	}

}
