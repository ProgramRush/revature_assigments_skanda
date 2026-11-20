
public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("Java is easy to learn"));
	}

	public static String reverseWords(String s) {
        StringBuilder out = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && Character.isWhitespace(s.charAt(i))) i--;
            if (i < 0) break;
            int end = i;
            while (i >= 0 && !Character.isWhitespace(s.charAt(i))) i--;
            if (out.length() > 0) out.append(' ');
            out.append(s, i + 1, end + 1);
        }
        return out.toString();
    }
}
