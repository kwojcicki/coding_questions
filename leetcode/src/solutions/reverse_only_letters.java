package solutions;

public class reverse_only_letters {
	public String reverseOnlyLetters(String S) {
		char[] ret = new char[S.length()];

		for(int i = 0; i < S.length(); i++) {
			if(!Character.isAlphabetic(S.charAt(i))) {
				ret[i] = S.charAt(i);
			}
		}

		int right = S.length() - 1;
		for(int i = 0; i < S.length(); i++) {
			while(right >= 0 && !Character.isAlphabetic(S.charAt(right))) {
				right--;
			}

			if(Character.isAlphabetic(S.charAt(i))) {
				ret[right] = S.charAt(i);
				right--;
			}
		}

		return new String(ret);
	}


	public static void main(String[] args) {
		char[] ret = new char[3];
		System.out.println(ret[0] == 0);
	}
}
