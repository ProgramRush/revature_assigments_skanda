
public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
        int b = 20;
        swapArithmetic(a, b);
        swapXor(a, b);
	}

	public static void swapArithmetic(int a, int b) {
		long sum = (long) a + b;
		a = (int) (sum - a);
		b = (int) (sum - b);
		
		System.out.println("Arithmetic -> a = " + a + ", b = " + b);
	}
	
	public static void swapXor(int a, int b) {
		a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("XOR        -> a = " + a + ", b = " + b);
	}
}
