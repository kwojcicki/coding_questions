package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class implement_stack_using_queues {
	class MyStack {

		Queue<Integer> q = new LinkedList<>();
		public MyStack() {

		}

		public void push(int x) {
			q.add(x);
		}

		public int pop() {
			int prev = -1;
			do {
				q.add(prev);
				prev = q.poll();
			} while(q.peek() != -1);
			q.poll();
			return prev;
		}

		public int top() {
			int pop = pop();
			q.add(pop);
			return pop;
		}

		public boolean empty() {
			return q.isEmpty();
		}
	}
}
