package solutions;

public class remove_all_adjacent_duplicates_in_string {
	public String removeDuplicates(String s) {
		char[] c = s.toCharArray();
		int p = 0;

		for(char a: c) {
			if(p > 0 && c[p - 1] == a) {
				p--;
			} else {
				c[p++] = a;
			}
		}

		return new String(c).substring(0, p);
	}
}
