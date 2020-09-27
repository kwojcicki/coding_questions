    
package solutions;

import java.util.stream.IntStream;

public class evaluate_division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++){
            
            if(!graph.containsKey(equations.get(i).get(0)))
                graph.put(equations.get(i).get(0), new HashMap<>());
            if(!graph.containsKey(equations.get(i).get(1)))
                graph.put(equations.get(i).get(1), new HashMap<>());
            
            
            graph.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            graph.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
            
        }
        
        List<Double> ret = new ArrayList<>();
        
        for(List<String> query: queries){
            Set<String> seen = new HashSet<>();
            ret.add(dfs(query.get(0), query.get(1), 1, seen, graph));
        }
        
        return ret.stream().mapToDouble(d -> d).toArray();
    }
    
    public double dfs(String from, String to, double curr, Set<String> seen, Map<String, Map<String, Double>> graph){
        if(seen.contains(from)){
            return -1;
        }
        
        seen.add(from);
        
        
        double ret = -1;
        if(!graph.containsKey(from)){
            return ret;
        }
        
        
        if(from.equals(to)){
            return curr;
        }
        for(Map.Entry<String, Double> pair : graph.get(from).entrySet()){
            ret = dfs(pair.getKey(), to, curr * pair.getValue(), seen, graph);
            if(ret != -1){
                return ret;
            }
        }
        
        return ret;
    }
}