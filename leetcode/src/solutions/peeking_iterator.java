package solutions;

import java.util.Iterator;

public class peeking_iterator {

	class PeekingIterator implements Iterator<Integer> {
		Iterator<Integer> iterator;
		Integer peek = null;
		public PeekingIterator(Iterator<Integer> iterator) {
			// initialize any member here.
			this.iterator = iterator;
			if(this.iterator.hasNext())
				peek = iterator.next();
		}

		// Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return peek;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer tmp = peek;
			peek = iterator.hasNext() ? iterator.next() : null;
			return tmp;
		}

		@Override
		public boolean hasNext() {
			return peek != null;
		}
	}
}
