package solutions;

import java.util.Arrays;

public class minimum_rounds_to_complete_all_tasks {
	public int minimumRounds(int[] tasks) {
		int ret = 0;

		Arrays.sort(tasks);

		int s = 0;

		for(int e = 0; e <= tasks.length; e++) {
			if(e == tasks.length || tasks[e] != tasks[s]) {
				int l = e - s;
				// System.out.println(l);
				// if(l % 2 != 0 && (l % 3) % 2 != 0) return -1;
				while(l % 3 != 0 && l > 0) { ret++; l -= 2; }
				if(l < 0) return -1;
				ret += l / 3;
				s = e;
			}
		}

		return ret;
	}
}
