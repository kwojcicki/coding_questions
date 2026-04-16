package solutions;

class closest_equal_element_queries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	map.compute(nums[i], (k,v) -> v == null ? new TreeSet<>() : v).add(i);
        }
        
        for(int i = 0; i < queries.length; i++) {
        	int idx = queries[i];
        	TreeSet<Integer> set = map.get(nums[idx]);
            if(set.size() == 1) {
        		ret.add(-1); continue;
        	}
        	Integer left = set.lower(idx);
        	Integer right = set.higher(idx);
        	
        	int min = Math.min(
        			left == null ? idx + (nums.length - set.last()) : idx - left,
        			right == null ? set.first() + (nums.length - idx) : right - idx
        					);
        	
        	ret.add(min);
        }
        
        return ret;
    }
}
