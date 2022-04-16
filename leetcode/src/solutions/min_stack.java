package solutions;

import java.util.Stack;

public class min_stack {

	class MinStack {

		class Node {
			public int value;
			public int min;
			
			public Node(int value, int min) {
				this.value = value;
				this.min = min;
			}
		}

		int currentMin = Integer.MAX_VALUE;
		private Stack<Node> stack = new Stack<>();
		
		public MinStack() {

		}

		public void push(int val) {
			Node n = new Node(val, currentMin);
			
			if(val < currentMin) {
				this.currentMin = val;
			}
			
			stack.push(n);
		}

		public void pop() {
			Node n = stack.pop();
			
			this.currentMin = n.min;
		}

		public int top() {
			return stack.peek().value;
		}

		public int getMin() {
			return currentMin;
		}
	}
}
