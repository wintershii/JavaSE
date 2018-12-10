package test.com;

interface OutInterface2{
	public int getValue();
}

public class OuterClass4 {
	public OutInterface2 doit() {
		return new OutInterface2(){			//声明匿名内部类
			private int i =7;
			public int getValue() {
				return i;
			}
		};
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		OuterClass4 out = new OuterClass4();
		OutInterface2 inter = out.doit();
		n = inter.getValue();
		System.out.println(n);
	}

}
