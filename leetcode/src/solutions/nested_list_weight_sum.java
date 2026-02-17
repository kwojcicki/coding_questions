package solutions;

class nested_list_weight_sum {

 public interface NestedInteger {
     // Constructor initializes an empty nested list.
      public NestedInteger();
 
      // Constructor initializes a single integer.
      public NestedInteger(int value);
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // The result is undefined if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);
 
   // @return the nested list that this NestedInteger holds, if it holds a nested list
      // The result is undefined if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
 

  
    public int depthSum(List<NestedInteger> nestedList) {
        return recurse(nestedList, 0, 1);
    }

    public int recurse(List<NestedInteger> nestedList, int idx, int depth){
        if(idx == nestedList.size()) return 0;

        if(nestedList.get(idx).isInteger()){
            return nestedList.get(idx).getInteger() * depth + recurse(nestedList, idx + 1, depth);
        }

        return recurse(nestedList.get(idx).getList(), 0, depth + 1) + recurse(nestedList, idx + 1, depth);
    }
}
