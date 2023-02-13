package solutions;

public class count_odd_numbers_in_an_interval_range {
	public int countOdds(int low, int high) {
		if(low % 2 == 0){
			return (high - low + 1) / 2;
		}

		return (high - low) / 2 + 1;
	}
}
