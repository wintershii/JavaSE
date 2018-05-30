package com.lzw;

class Parents{
	private final void doit() {
		System.out.println("父类doit()");
	}
	final void doit2() {
		System.out.println("父类doit2()");
	}
	public void doit3() {
		System.out.println("父类doit3()");
	}
	
}

class Sub extends Parents{
	public final void doit() {
		System.out.println("子类doit()");
	}
	
//	final void doit2() {				//final方法不可被覆盖
//		System.out.println("子类doit2()");
//	}
	
	public void doit3() {
		System.out.println("子类doit3()");
	}
}

public class FinalMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub s = new Sub();			//实例化对象
		s.doit();
		s.doit2();
		s.doit3();
		Parents p = s;			//向上转型
		//p.doit();    //不能调用private 方法
		p.doit2();
		p.doit3();
		
		
	}

}
