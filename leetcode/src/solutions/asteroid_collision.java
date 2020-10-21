package solutions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class asteroid_collision {
	public int[] asteroidCollision(int[] asteroids) {
		List<Integer> ret = new ArrayList<>();

		Deque<Integer> q = new LinkedList<>();

		for(int i: asteroids) {
			if(i > 0) {
				q.add(i);
			} else {

				while(!q.isEmpty() && q.peekLast() < i * -1) q.pollLast();
				if(q.isEmpty()) ret.add(i);
				else if(q.peekLast() == i * -1) q.pollLast();
			}
		}

		while(!q.isEmpty()) {
			ret.add(q.pollFirst());
		}

		return ret.stream().mapToInt(i->i).toArray();
	}
}
