package com.ravi.contactsapp.test;

public class TestClass {

	public static void main(String[] args) {

		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("contactsapp-servlet_test.xml");

		Integer[] nameInt = { 5, 6, 3, 9, 9, 10 };
	
		String gudMorning="Good Morning ";

	String hello="Hello,";

		for (Integer iValue : nameInt) {
			System.out.println(hello+gudMorning +iValue);

		}

	}

}
