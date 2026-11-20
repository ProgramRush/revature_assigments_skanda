
public class FirstNonRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUnique("swiss"));  // w
        System.out.println(firstUnique("aabbcc")); // No non-repeated character
	}
	
	public static String firstUnique(String s) {
		int[] freq = new int[256];

		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) return String.valueOf(s.charAt(i));
        }	
		return "No non-repeated character";
	}
}
