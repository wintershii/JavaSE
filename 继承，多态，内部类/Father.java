package com.lzw;

public class Father {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s = new Son();
		s.sayHello();
		s.sayHello("999");
	}
	
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}

class Son extends Father{
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("hello by ");
	}
	
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("hello overloading " + name);
	}
}
