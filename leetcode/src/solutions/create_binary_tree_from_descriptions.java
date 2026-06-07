package solutions;

class create_binary_tree_from_descriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> hasParents = new HashSet<>();

        for(int[] d: descriptions){
            int parent = d[0];
            int child = d[1];
            boolean isLeft = d[2] == 1;

            TreeNode parentNode = map.computeIfAbsent(parent, (x) -> new TreeNode(x));
            TreeNode childNode = map.computeIfAbsent(child, (x) -> new TreeNode(x));
            if(isLeft) parentNode.left = childNode;
            else parentNode.right = childNode;

            hasParents.add(child);
        }

        for(int i: map.keySet()){
            if(!hasParents.contains(i)) return map.get(i);
        }

        return null;
    }
}
