package solutions;

public class gas_station {
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

		//System.out.println("start: " + start);
		while(curr != start) {
			//System.out.println(g);
			if(g < 0) {
				return -1;
			}

			g = g + gas[curr] - cost[ curr ];

			curr = (curr + 1) % gas.length;
		}


		return ( g < 0 ) ? -1 : start;
	}
}
