package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class string_compression {
	public int compress(char[] chars) {

		if(chars == null || chars.length == 0) return 0;

		int writePtr = 0;
		char prev = chars[0];
		int count = 0;
		Deque<Character> s = new LinkedList<>();

		for(int i = 0; i < chars.length; i++) {
			char c = chars[i];

			if(c != prev) {
				chars[writePtr] = prev;
				writePtr++;
				if(count != 1) {
					while(count > 0) {
						s.add((char) (count % 10 + '0'));
						count = count / 10;
					}

					while(!s.isEmpty()) {
						chars[writePtr] = s.pollLast();
						writePtr++;
					}
				}
				prev = c;
				count = 0;
			}
			count++;
		}

		chars[writePtr] = prev;
		writePtr++;
		if(count == 1) return writePtr;

		while(count > 0) {
			s.add((char) (count % 10 + '0'));
			count = count / 10;
		}

		while(!s.isEmpty()) {
			chars[writePtr] = s.pollLast();
			writePtr++;
		}

		return writePtr;
	}
}
