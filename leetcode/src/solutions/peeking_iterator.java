package solutions;

import java.util.Iterator;

public class peeking_iterator {

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Integer peek = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peek != null) return peek;
        peek = iterator.next();
        
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(peek == null) {
			return iterator.next();
		}
		
		Integer tmp = peek;
		peek = null;
		return tmp;
	}
	
	@Override
	public boolean hasNext() {
	    return peek != null || iterator.hasNext();
	}
}
}
