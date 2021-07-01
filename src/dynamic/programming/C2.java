package dynamic.programming;

public class C2 extends C1{
	private void m1() {
		System.out.println("c2 m1");
	}
	private static void m2() {
		System.out.println("c2 m2");
	}
	
	public static void main(String[] args) {
		C2 c2 = new C2();
		c2.m1();
		c2.m2();
	}
}
