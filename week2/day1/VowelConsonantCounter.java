
public class VowelConsonantCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countVowelsAndConsonants("Programming");
		
		countVowelsAndConsonants("Hello, World! 123");
	}
	
	public static void countVowelsAndConsonants(String text) {
		int vowels = 0;
        int consonants = 0;
        
        if (text != null) {
        	for (int i = 0; i < text.length(); i++) {
        		char ch = text.charAt(i);
        		
        		if(Character.isLetter(ch)) {
        			char lower = Character.toLowerCase(ch);
        			if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'u' || lower == 'o') {
        				vowels++;
        			}
        			else {
        				consonants++;
        			}
        		}
        	}	
        	
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
	}

}
