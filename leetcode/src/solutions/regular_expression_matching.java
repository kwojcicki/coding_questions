
package solutions;

class regular_expression_matching {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public boolean isMatch(char[] s, char[] p, int sIdx, int pIdx){
        // System.out.println(sIdx + " " + pIdx);
        if(sIdx == s.length && pIdx == p.length) return true;
        if(sIdx == s.length){
            while(pIdx + 1 <= p.length - 1 && p[pIdx + 1] == '*') pIdx += 2;
            return pIdx == p.length;
        }
        if(pIdx == p.length) return false;

        if(pIdx + 1 < p.length){
            if(p[pIdx + 1] == '*'){

                int tmpS = sIdx;
                while(tmpS < s.length && (s[tmpS] == p[pIdx] || p[pIdx] == '.')){
                    tmpS++;
                    if(isMatch(s, p, tmpS, pIdx + 2)) return true;
                }

                return isMatch(s, p, sIdx, pIdx + 2);
            }

            if(p[pIdx] == '.') return isMatch(s, p, sIdx + 1, pIdx + 1);
            return s[sIdx] == p[pIdx] && isMatch(s, p, sIdx + 1, pIdx + 1);
        } else {
            if(p[pIdx] == '.') return isMatch(s, p, sIdx + 1, pIdx + 1);
            return s[sIdx] == p[pIdx] && isMatch(s, p, sIdx + 1, pIdx + 1);
        }
    }
}
