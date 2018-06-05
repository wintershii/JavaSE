package com.lzw;

public class TheSameName {
	private int x = 2;
	
	private class inner{
		private int x = 9;
		
		public void doit(int x) {
			x++;
			System.out.println(x);
			this.x++;
			System.out.println(this.x);
			TheSameName.this.x++;
			System.out.println(TheSameName.this.x++);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheSameName t = new TheSameName();
		inner s = t.new inner();
		s.doit(6);
	}

}
