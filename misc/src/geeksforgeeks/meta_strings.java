package geeksforgeeks;

public class meta_strings {

	public static void main(String[] args) {
		System.out.println(meta("geeks", "keegs"));
		System.out.println(meta("rsting", "string"));
		System.out.println(meta("Converse", "Conserve"));
	}

	public static boolean meta(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		int firstChar = -1, secondChar = -1;
		
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				
				if(secondChar != -1 && firstChar != -1) {
					return false;
				}
				
				if(firstChar == -1) {
					firstChar = i;
				} else if(secondChar == -1) {
					secondChar = i;
				}
				
			}
		}
		
		return (firstChar != -1 && secondChar != -1 &&
					s1.charAt(firstChar) == s2.charAt(secondChar) &&
					s1.charAt(secondChar) == s2.charAt(firstChar));
	}
	
}
