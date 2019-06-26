package solutions;

public class letter_tile_possibilities {

	public int numTilePossibilities(String tiles) {
		int[] alpha = new int[26];
		for(char c: tiles.toCharArray()) {
			alpha[c - 'A']++;
		}
		return count(alpha);
	}
	
	public int count(int[] alpha) {
		
		int ret = 0;
		
		for(int i = 0; i < alpha.length; i++) {
			if(alpha[i] == 0) {
				continue;
			}
			ret++;
			alpha[i]--;
			ret += count(alpha);
			alpha[i]++;
		}
		
		return ret;
	}

	public static void main(String[] args) {
	}
	
}
