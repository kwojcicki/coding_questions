package solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class employee_importance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        employees.forEach(i -> map.put(i.id, i));
        
        return dfs(map, id);
    }
    
    public static int dfs(Map<Integer, Employee> map, int id) {
    	int ret = map.get(id).importance;
    	for(int e: map.get(id).subordinates){
    		ret += dfs(map, e);
    	}
    	
    	return ret;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};