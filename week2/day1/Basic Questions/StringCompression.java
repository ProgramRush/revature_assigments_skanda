
public class StringCompression {
	public static void main(String[] args) {
        System.out.println(compress("aaabbccccd")); // a3b2c4d1
        System.out.println(compress("abc"));        // a1b1c1
    }
	public static String compress(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) count++;
            else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
		return sb.toString();
	}
}
