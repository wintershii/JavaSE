package com.lzw;

public class OuterClass {
	innerClass in = new innerClass();		//在外部类实例化内部类对象引用
	
	public void ouf() {					//在外部类中调用内部类方法
		in.inf();
	}
	
	class innerClass{
		innerClass(){				//内部类构造方法
			
		}
		public void inf() {		//内部类成员方法
			
		}
		int y = 0;			//定义内部类成员变量
		
	}
	
	public innerClass doit() {			//外部类方法，返回值为内部类引用
		in.y = 4;					
		
		return in;		//返回内部类引用
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OuterClass out = new OuterClass();
		OuterClass.innerClass in = out.doit();
		OuterClass.innerClass in2 = out.new innerClass();
		System.out.println(in.y);
	}

}
