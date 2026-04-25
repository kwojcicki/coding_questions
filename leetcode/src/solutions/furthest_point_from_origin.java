
package solutions;
class furthest_point_from_origin {
    public int furthestDistanceFromOrigin(String moves) {
        int ret = 0, blank = 0;
        for(char c: moves.toCharArray()){
            if(c == 'L') ret--;
            else if(c == 'R') ret++;
            else blank++;
        }

        return Math.max(ret + blank, Math.abs(ret - blank));
    }
}
