package solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class flatten_nested_list_iterator {
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return empty list if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */
	public class NestedIterator implements Iterator<Integer> {
        List<Pair> indices = new ArrayList<>();
		Integer nextValue = null; 
		public NestedIterator(List<NestedInteger> nestedList) {
			indices.add(new Pair(nestedList, -1));
		}

		@Override
		public Integer next() {
			Integer tmp = nextValue;
			nextValue = null;
			return tmp;
		}

		// [1,[4,[6]]]
		// [0] + 1
		private Integer getNext() {
			
			int index = indices.size() - 1;
			indices.get(index).position += 1;
			
			while(true) {
				Pair pair = indices.get(index);
				if(pair.curr.size() > pair.position) {
					if(pair.curr.get(pair.position).isInteger()) {
						return pair.curr.get(pair.position).getInteger();
					} else {
						indices.add(new Pair(pair.curr.get(pair.position).getList(), -1));
						return getNext();
					}
				} else {
					indices.remove(index);
					index--;
                    if(index == -1) return null;
					indices.get(index).position += 1;
				}
			}
		}
		
		@Override
		public boolean hasNext() {
			
			if(nextValue == null) {
				nextValue = getNext();
			}
			// System.out.println(nextValue);
            // System.out.println(nextValue != null);
			return nextValue != null;
		}
	}
	
	class Pair {
		List<NestedInteger> curr;
		Integer position;
		public Pair(List<NestedInteger> curr, Integer position) { this.curr = curr; this.position = position; }
	}

	public interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return empty list if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}
}
