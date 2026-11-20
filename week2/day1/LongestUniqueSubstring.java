
import java.util.Arrays;
public class LongestUniqueSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));  
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int[] last = new int[256];
		Arrays.fill(last, -1);
		int best = 0, left = 0;
		for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last[c] >= left) {
            	left = last[c] + 1;
            }
            last[c] = right;
            best = Math.max(best, right - left + 1);
        }
		return best;
	}

}
