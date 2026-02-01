package solutions;

class binary_tree_vertical_order_traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> cols = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        cols.add(0);
        while(!queue.isEmpty()){
            TreeNode q = queue.poll();
            Integer col = cols.poll();
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(q.val);
            if(q.left != null){
                queue.add(q.left);
                cols.add(col - 1);
            }
            if(q.right != null){
                queue.add(q.right);
                cols.add(col + 1);
            }
            min = Math.min(col, min); max = Math.max(col, max);
        }

        for(int i = min; i <= max; i++) ret.add(map.get(i));        
        return ret;
    }
}
