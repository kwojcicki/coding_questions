package solutions;

class jump_game_iii {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        arr[start] = -arr[start];
        while(!q.isEmpty()){
            int idx = q.poll();
            int val = Math.abs(arr[idx]);

            if(val == 0) return true;

            if(idx - val >= 0 && arr[idx - val] >= 0){
                q.add(idx - val);
                arr[idx - val] = -arr[idx - val];
            }
            if(idx + val < arr.length && arr[idx + val] >= 0){
                q.add(idx + val);
                arr[idx + val] = -arr[idx + val];
            }
        }

        return false;
    }
}
