package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class jump_game_iv {

	public int minJumps(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();

		for(int i = 0; i < arr.length; i++) {
			map.putIfAbsent(arr[i], new ArrayList<>());
			if(i > 0 && i < arr.length - 1 && arr[i - 1] == arr[i] && arr[i] == arr[i + 1]) continue;
			map.get(arr[i]).add(i);
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] s = new boolean[arr.length];
		s[0] = true;

		q.add(0);

		int ret = 0;
		while(!q.isEmpty()) {
			ret++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Integer index = q.poll();

				if(index == arr.length - 1) {
					return ret - 1;
				}

				if(index < 0) continue;

				if(index > 0 && !s[index - 1]){
					q.add(index - 1);
					s[index] = true;
				}

				if(index < arr.length - 1 && !s[index + 1]){
					q.add(index + 1);
					s[index] = true;
				}

				for(int wormhole: 
					map.get(arr[index])){
					if(index == wormhole) continue;
					if(s[wormhole]) continue;
					q.add(wormhole);
					s[wormhole] = true;
				}

				map.get(arr[index]).clear();
			}
		}

		return ret;
	}


	public int minJumps1(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();

		for(int i = 0; i < arr.length; i++) {
			map.putIfAbsent(arr[i], new ArrayList<>());
			if(i > 0 && i < arr.length - 1 && arr[i - 1] == arr[i] && arr[i] == arr[i + 1]) continue;
			map.get(arr[i]).add(i);
		}

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> s = new HashSet<>();
		Set<Integer> values = new HashSet<>();


		q.add(0);

		int ret = 0;
		while(!q.isEmpty()) {
			ret++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Integer index = q.poll();

				if(s.contains(index)) continue;
				s.add(index);

				if(index == arr.length - 1) {
					return ret - 1;
				}

				if(index < 0) continue;

				if(index > 0 && !s.contains(index - 1) && !values.contains(arr[index - 1]))
					q.add(index - 1);

				if(index < arr.length - 1 && !s.contains(index + 1) && !values.contains(arr[index + 1]))
					q.add(index + 1);


				if(values.contains(arr[index])) continue;

				for(int wormhole: 
					map.get(arr[index])){
					if(index == wormhole) continue;
					if(s.contains(wormhole)) continue;
					q.add(wormhole);
				}

				values.add(arr[index]);
			}
		}

		return ret;
	}
}
