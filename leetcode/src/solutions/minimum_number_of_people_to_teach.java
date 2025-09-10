package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class minimum_number_of_people_to_teach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> missingPeople = new HashSet<>();
        int[] have = new int[n + 1];
        
        List<Set<Integer>> languageSets = new ArrayList<>();
        languageSets.add(new HashSet<>());
        for(int[] langs: languages) {
        	Set<Integer> lang = new HashSet<>();
        	for(int i: langs) lang.add(i);
        	languageSets.add(lang);
        }
        
        for(int[] f: friendships) {
        	Set<Integer> l = languageSets.get(f[0]);
        	Set<Integer> r = languageSets.get(f[1]);
        	boolean match = false;
        	
        	for(Integer i: l) {
        		if(r.contains(i)) {
        			match = true; break;
        		}
        	}
        	
        	if(!match) {
        		missingPeople.add(f[0]);
        		missingPeople.add(f[1]);
        	}
        }
        
        for(int missing: missingPeople) {
        	for(int i: languageSets.get(missing)) {
        		have[i]++;
        	}
        }
        
        int ret = missingPeople.size();
        
        for(int h: have) {
        	ret = Math.min(missingPeople.size() - h, ret);
        }
        
        return ret;
    }
}
