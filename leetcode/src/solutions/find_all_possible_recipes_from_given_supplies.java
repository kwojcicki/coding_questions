package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class find_all_possible_recipes_from_given_supplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ret = new ArrayList<>();
        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));
        
        Map<String, Integer> inEdges = new HashMap<>();
        Map<String, List<String>> makes = new HashMap<>();
        for(int i = 0; i < ingredients.size(); i++) {
    		inEdges.put(recipes[i], ingredients.get(i).size());
        	for(String ingredient: ingredients.get(i)) {
        		makes.putIfAbsent(ingredient, new ArrayList<>());
        		makes.get(ingredient).add(recipes[i]);
        	}
        }
        
        Queue<String> q = new LinkedList<>();
        for(String supply: supplies) q.add(supply);
        
        while(!q.isEmpty()) {
        	String ingredient = q.poll();
        	if(recipesSet.contains(ingredient)) {
        		ret.add(ingredient);
        	}
        	
        	for(String consumer: makes.getOrDefault(ingredient, new ArrayList<String>())) {
        		if(inEdges.compute(consumer, (k,v) -> v - 1) == 0) {
        			q.add(consumer);
        		}
        	}
        }
        
        return ret;
    }
}
