package com.lzw;


//abstract class OutAbstractClass{
//	public abstract int add(int a,int b);
//	
//	public int sub(int a,int b) {
//		return a - b;
//	}
//	
//}

interface OutInterface{
	int add(int a,int b);
	int sub(int a,int b);
}

public class AbstractClassAndInterface implements OutInterface{
	
	public int add(int a,int b) {
		return a + b;
	}
	
	public int sub(int a,int b) {
		return a - b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5,b = 2;
		AbstractClassAndInterface test = new AbstractClassAndInterface();
		System.out.println("a+b的结果是:"+test.add(a, b));
		System.out.println("a-b的结果是:"+test.sub(a, b));
		
	}

}
