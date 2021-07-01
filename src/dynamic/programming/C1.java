package dynamic.programming;

public class C1 extends QuickTest {
	private void m1() {
		System.out.println("c1 m1");
	}
	private static void m2() {
		System.out.println("c1 m2");
	}
	
	public static void main(String[] args) {
		C1 c1 = new C1();
		c1.m1();
		c1.m2();
	}
	
}
