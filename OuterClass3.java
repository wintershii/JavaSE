package com.lzw;

interface OutInterface2{
	public void f();
}

public class OuterClass3 {
	
	public OutInterface2 doit (final String x) {	//doit()方法参数final类型
		//在doit()方法中定义一个内部类
		class InnerClass2 implements OutInterface2{
			InnerClass2(String s){
				s = x;
				System.out.println(s);
			}
			public void f() {
				System.out.println("访问局部内部类中的f()方法");
			}
		}
		return new InnerClass2("doit");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			OuterClass3 out = new OuterClass3();
			OutInterface2 inter = out.doit("shi");
			inter.f();
	}

}
