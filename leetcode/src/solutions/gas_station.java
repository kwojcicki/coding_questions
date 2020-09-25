package solutions;

public class gas_station {


	public int canCompleteCircuit1(int[] gas, int[] cost) {
		int[] sum = new int[gas.length];
		for(int i = 0; i < gas.length; i++) sum[i] = gas[i] - cost[i];

		int left = sum.length - 1, right = 0;
		int curr = sum[left];
		while(left > right) {
			if(curr >= 0) {
				curr += sum[right];
				right++;
			} else {
				left--;
				curr += sum[left];
			}
		}

		return curr >= 0 ? left : -1;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		for(int i = 0; i < gas.length; i++) {
			if(good(gas, cost, i) != - 1) {
				return good(gas, cost, i);
			}
		}


		return -1;
	}

	public int good(int[] gas, int[] cost, int start) {
		int g = gas[start] - cost[ start ];
		int curr = ( start + 1 ) % gas.length;

		while(curr != start) {
			if(g < 0) {
				return -1;
			}

			g = g + gas[curr] - cost[ curr ];

			curr = (curr + 1) % gas.length;
		}


		return ( g < 0 ) ? -1 : start;
	}
}
