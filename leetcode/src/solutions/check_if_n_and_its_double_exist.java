package solutions;

public class check_if_n_and_its_double_exist {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet<>();

        for(int i: arr){
            if(s.contains(i / 2) && (i / 2) * 2 == i){
                return true;
            } else if(s.contains(i * 2)){
                return true;
            }
            s.add(i);
        }

        return false;
    }
}
