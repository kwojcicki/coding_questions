package solutions;

public class count_number_of_teams {
	public int numTeams(int[] rating) {

		int ret = 0;

		int[] dpL = new int[rating.length];
		int[] dpH = new int[rating.length];
		dpL[0] = 0; dpH[0] = 0;
		for(int i = 1; i < dpL.length; i++) {
			for(int j = 0; j < i; j++) {
				if(rating[j] < rating[i]) dpL[i]++;
				if(rating[j] > rating[i]) dpH[i]++;
				if(dpL[j] > 0 && rating[j] < rating[i]) ret += dpL[j];
				if(dpH[j] > 0 && rating[j] > rating[i]) ret += dpH[j];
			}
		}

		return ret;
	}
}
