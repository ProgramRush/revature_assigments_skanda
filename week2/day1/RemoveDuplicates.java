
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateChars("programming"));
	}
	public static String removeDuplicateChars(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.indexOf(String.valueOf(c)) == -1) {
            	sb.append(c);
            }
        }
		return sb.toString();
	}
}
