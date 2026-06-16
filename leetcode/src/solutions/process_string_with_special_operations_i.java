package solutions;

class process_string_with_special_operations_i {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '*'){
                if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            } else if(c == '#'){
                sb.append(sb);
            } else if(c == '%'){
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
