package solutions;

public class count_and_say {
	public String countAndSay(int n) {
		if(n == 1) return "1";

		char[] s = countAndSay(n - 1).toCharArray();
		StringBuilder sb = new StringBuilder();

		int count = 1;
		char prev = s[0];
		for(int i = 1; i < s.length; i++) {
			if(s[i] != prev) {
				sb.append(Integer.toString(count) + "" + prev);
				count = 1;
				prev = s[i];
			} else {
				count++;
			}
		}
		sb.append(Integer.toString(count) + "" + prev);
		// System.out.println(sb.toString());
		return sb.toString();
	}
}
