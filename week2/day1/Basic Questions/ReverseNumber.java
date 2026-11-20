
public class ReverseNumber {

	public static void main(String[] args) {
        System.out.println(reverseInt(12345)); // 54321
        System.out.println(reverseInt(908));   // 809
        System.out.println(reverseInt(-123));  // -321
        System.out.println(reverseInt(1200));  // 21
    }
	
	public static int reverseInt(int n) {
		int reversed = 0;
		
		while(n != 0) {
			int digit = n % 10;
			n /= 10;
			
			if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                throw new ArithmeticException("Integer overflow while reversing number");
            }
			
			if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
	                throw new ArithmeticException("Integer overflow while reversing number");
	        }
			
			reversed = reversed * 10 + digit;
			
		}
		return reversed;
	}

}
