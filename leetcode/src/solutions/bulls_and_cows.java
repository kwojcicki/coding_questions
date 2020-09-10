package solutions;

public class bulls_and_cows {
	public String getHint(String secret, String guess) {
		int[] cow = new int[10];
		int bulls = 0;
		int cows = 0;

		for(int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) bulls++;
			else cow[guess.charAt(i) - '0']++;
		}

		for(int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i) != guess.charAt(i)) {
				if(cow[secret.charAt(i) - '0'] > 0) {
					cows++;
					cow[secret.charAt(i) - '0']--;
				}
			}
		}

		return bulls + "A" + cows + "B"; 
	}
}
