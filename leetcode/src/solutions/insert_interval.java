package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insert_interval {

	public static int[][] insert(int[][] intervals, int[] newInterval){
		System.out.println("--");
		List<Integer[]> ret = new ArrayList<>();


		int i = 0;

		while(i < intervals.length && intervals[i][1] < newInterval[0]) {
			ret.add(new Integer[] { intervals[i][0], intervals[i][1] });
			i++;
		}

		while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

			i++;
		}
		ret.add(new Integer[] { newInterval[0], newInterval[1]});
		while(i < intervals.length) {
			ret.add(new Integer[] { intervals[i][0], intervals[i][1] });
			i++;
		}

		int[][] r = new int[ret.size()][2];
		for(i = 0; i < ret.size(); i++) {
			r[i][0] = ret.get(i)[0];
			r[i][1] = ret.get(i)[1];
		}

		for(int[] a: r) {
			System.out.println(Arrays.toString(a));
		}

		return r;
	}

	public static int[][] insert1(int[][] intervals, int[] newInterval) {
		List<Integer[]> ret = new ArrayList<>();

		int[] addingInterval = null;
		boolean added = false;

		for(int i = 0; i < intervals.length; i++) {
			if(intervals[i][0] <= newInterval[0] && newInterval[1] <= intervals[i][1] && !added && addingInterval == null) {
				added = true;
				addingInterval = new int[2];
				ret.add(new Integer[] {intervals[i][0], intervals[i][1]});
			} else if(intervals[i][1] >= newInterval[0] && addingInterval == null) {
				System.out.println("1");
				addingInterval = new int[2];

				if(intervals[i][0] > newInterval[1]) {
					added = true;
					ret.add(new Integer[] {newInterval[0], newInterval[1]});
					ret.add(new Integer[] {intervals[i][0], intervals[i][1]});
				} else {
					addingInterval[0] = Math.min(intervals[i][0], newInterval[0]);
					addingInterval[1] = Math.max(newInterval[1], intervals[i][1]);	
				}
			} else if(intervals[i][0] <= newInterval[1] && addingInterval != null && !added) {
				System.out.println("2");
				addingInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			} else if(intervals[i][0] > newInterval[1] && !added) {
				System.out.println("3");
				ret.add(new Integer[] {addingInterval[0], Math.max(addingInterval[1], newInterval[1])});
				added = true;
				ret.add(new Integer[] {intervals[i][0], intervals[i][1]});
			} else {
				System.out.println("4");
				ret.add(new Integer[] {intervals[i][0], intervals[i][1]});
			}
		}

		if(!added && addingInterval != null) {
			ret.add(new Integer[] {addingInterval[0], addingInterval[1]});
		} else if(!added) {
			ret.add(new Integer[] {newInterval[0], newInterval[1]});
		}

		int[][] r = new int[ret.size()][2];
		for(int i = 0; i < ret.size(); i++) {
			r[i][0] = ret.get(i)[0];
			r[i][1] = ret.get(i)[1];
		}

		for(int[] a: r) {
			System.out.println(Arrays.toString(a));
		}

		return r;
	}

	public static void main(String[] args) {
		insert(new int[][] {
			{1,3},{6,9} 
		}, new int[] {2,5});

		insert(new int[][] {
			{1,2},{3,5},{6,7},{8,10},{12,16}
		}, new int[] {4,8});

		insert(new int[][] {
			{1,5 }
		}, new int[] {2,7});

		insert(new int[][] {
			{1,5 }
		}, new int[] {5,7});

		insert(new int[][] {
			{1,5 }
		}, new int[] {0, 3});

		insert(new int[][] {
			{1,5}
		}, new int[] {0, 0});

		insert(new int[][] {
			{1,5}, {6,8}
		}, new int[] {0, 9});

	}
}
