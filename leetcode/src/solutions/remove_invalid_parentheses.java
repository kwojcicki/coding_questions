package solutions;

class remove_invalid_parentheses {
    public List<String> removeInvalidParentheses(String s) {
        int open = 0; int invalid = 0;
        for(char c: s.toCharArray()){
            if(c == ')'){
                if(open > 0) open--;
                else invalid++;
            } else if(c == '(') {
                open++;
            }
        }
        
        List<String> ret = new ArrayList<>();
        Set<String> unique = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        
        recurse(0, s.toCharArray(), curr, invalid, open, unique, 0);
        
        for(String str: unique) ret.add(str);
        
        return ret;
    }
    
    public void recurse(int index, char[] inputString, StringBuilder curr, int closeToRemove, int openToRemove, Set<String> unique, int open){
        
        if(index == inputString.length){
            if(closeToRemove == 0 && openToRemove == 0 && open == 0) unique.add(curr.toString());
            return;
        }
        
        if(inputString[index] == '(' && openToRemove > 0){
            recurse(index + 1, inputString, curr, closeToRemove, openToRemove - 1, unique, open);
        } else if(inputString[index] == ')' && closeToRemove > 0){
            recurse(index + 1, inputString, curr, closeToRemove - 1, openToRemove, unique, open);
        }
        
        if(inputString[index] == ')' && open <= 0) return;
        curr.append(inputString[index]);
        recurse(index + 1, inputString, curr, closeToRemove, openToRemove, unique, inputString[index] == ')' ? open - 1 : inputString[index] == '(' ? open + 1 : open);
        curr.setLength(curr.length() - 1);
    }
}
