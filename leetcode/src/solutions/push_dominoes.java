package solutions;

public class push_dominoes {
	public String pushDominoes(String dominoes) {
		char[] c = dominoes.toCharArray();
		char prev = '1';
		int last = 0;

		for(int i = 0; i < c.length; i++) {
			if(c[i] == 'L') {
				fill(prev, last, 'L', i - 1, c);
				prev = '1';
				last = i + 1;
			} else if(c[i] == 'R') {
				fill(prev, last, 'R', i - 1, c);
				prev = 'R';
				last = i + 1;
			}
		}

		if(last < c.length) {
			fill(prev, last, '1', c.length - 1, c);	
		}

		return new String(c);
	}

	private void fill(char prev, int last, char c, int i, char[] c2) {
		if(prev == '1' && c == 'L') {
			while(last <= i) {
				c2[last++] = 'L';
				c2[i--] = 'L';
			}
		} else if(c == '1' && prev == 'R') {
			while(last <= i) {
				c2[last++] = 'R';
				c2[i--] = 'R';
			}
		} else if(prev == 'R' && c == 'L') {
			while(last < i) {
				c2[last++] = 'R';
				c2[i--] = 'L';
			}
		} else if(prev == 'R' && c == 'R') {
			while(last <= i) {
				c2[last++] = 'R';
				c2[i--] = 'R';
			}
		}
	}

	public static void main(String[] args) {
		push_dominoes test = new push_dominoes();
		System.out.println(test.pushDominoes("RR.L"));
		System.out.println("RR.L");
		System.out.println(".L.R...LR..L..");
		System.out.println(test.pushDominoes(".L.R...LR..L.."));
		System.out.println("LL.RR.LLRRLL..");
		System.out.println(".L.R.");
		System.out.println(test.pushDominoes(".L.R."));
		System.out.println("LL.RR");
	}
}
