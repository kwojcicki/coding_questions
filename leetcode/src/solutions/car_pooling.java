package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class car_pooling {

	public boolean carPooling(int[][] trips, int capacity) {
		int[] stops = new int[1001];

		for(int[] trip: trips){
			stops[trip[1]] += trip[0];
			stops[trip[2]] -= trip[0];
		}

		for(int i = 0; i < 1001 && capacity >= 0; i++){
			capacity -= stops[i];
		}

		return capacity >= 0;
	}

	public boolean carPooling2(int[][] trips, int capacity) {

		int current = 0;

		for(int position = 0; position <= 1000; position++) {

			for(int[] a: trips) {
				if(position == a[1]) {
					current += a[0];
				}
			}

			for(int[] a: trips) {
				if(position == a[2]) {
					current -= a[0];
				}
			}

			if(current > capacity) {
				return false;
			}

		}


		return true;
	}

	public boolean carPooling1(int[][] trips, int capacity) {

		int curr = 0;

		Arrays.sort(trips, (a,b) -> {
			return Integer.compare(a[1], b[1]);
		});

		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
			return Integer.compare(a[2], b[2]);
		});

		for(int i = 0; i < trips.length; i++) {
			while(!q.isEmpty() && q.peek()[2] <= trips[i][1]) {
				curr -= q.poll()[0];
			}

			curr += trips[i][0];
			if(curr > capacity) {
				return false;
			}
			q.add(trips[i]);
		}

		return true;
	}















}
