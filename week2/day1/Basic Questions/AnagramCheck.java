
public class AnagramCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("listen", "silent") ? "Anagram" : "Not Anagram");
        System.out.println(isAnagram("hello", "world") ? "Anagram" : "Not Anagram");
        System.out.println(isAnagram("Debit Card", "Bad Credit") ? "Anagram" : "Not Anagram");
	}

	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null) {
            return false;
        }
		
		int[] freq = new int[128];
		int diff = 0;
        
        for (char c : s1.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                freq[Character.toLowerCase(c)]++;
                diff++;
            }
        }
        
        for (char c : s2.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                int idx = Character.toLowerCase(c);
                if (--freq[idx] < 0) return false;
                diff--;
            }
        }
        
        return diff == 0;
        
        
	}
}
