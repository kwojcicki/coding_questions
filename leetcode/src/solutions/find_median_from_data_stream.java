package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class find_median_from_data_stream {
	class MedianFinder {

		PriorityQueue<Integer> low = new PriorityQueue<>();
		PriorityQueue<Integer> high = new PriorityQueue<>(Collections.reverseOrder());
		/** initialize your data structure here. */
		public MedianFinder() {

		}

		public void addNum(int num) {
			low.add(num);

			high.add(low.poll());

			if(low.size() < high.size()) {
				low.add(high.poll());
			}
		}

		public double findMedian() {
			//System.out.println(low + " " + low.peek());
			//System.out.println(high + " " + high.peek());
			if(low.size() == high.size()) {
				return (low.peek() + high.peek()) / 2.0;
			} else if( low.size() > high.size()){
				return low.peek();
			}

			return high.peek();
		}
	}

}
