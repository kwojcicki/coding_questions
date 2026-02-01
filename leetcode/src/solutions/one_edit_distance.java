
package solutions;

class one_edit_distance {
    public boolean isOneEditDistance(String s, String t) {
        int index = 0;
        if(Math.abs(s.length() - t.length()) > 1) return false;

        while(index < s.length() && index < t.length()){
            if(s.charAt(index) == t.charAt(index)) index++;
            else {
                boolean addToS = s.substring(index).equals(t.substring(index + 1));
                boolean addToT = s.substring(index + 1).equals(t.substring(index));
                boolean edit = s.substring(index + 1).equals(t.substring(index + 1));
                return addToS || addToT || edit;
            }
        }

        return s.length() != t.length();
    }
}
