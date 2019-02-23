package solutions;

public class backspace_string_compare {
	public boolean backspaceCompare(String S, String T) {

		int s = S.length() - 1;
		int sBack = 0;
		int t = T.length() - 1;
		int tBack = 0;

		while(s >= 0 && t >= 0) {

			if(S.charAt(s) == '#') {
				s--;
				sBack++;
				continue;
			}

			if(T.charAt(t) == '#') {
				t--;
				tBack++;
				continue;
			}

			if(sBack > 0) {
				s--;
				sBack--;
				continue;
			}

			if(tBack > 0) {
				t--;
				tBack--;
				continue;
			}

			if(T.charAt(t) != S.charAt(s)) {
				return false;
			}

			s--;
			t--;

		}

		while(s >= 0) {
			if(S.charAt(s) == '#') {
				s--;
				sBack++;
			} else if(sBack > 0) {
				s--;
				sBack--;
			} else {
				break;
			}
		}
		
		while(t >= 0) {
			if(T.charAt(t) == '#') {
				t--;
				tBack++;
			} else if(tBack > 0) {
				t--;
				tBack--;
			} else {
				break;
			}
		}

		System.out.println(s + " " + t);
		return (s == t && s == -1);
	}

	public static void main(String[] args) {
		System.out.println(new backspace_string_compare().backspaceCompare("ab##", "c#d#"));
	}
}
