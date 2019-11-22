package solutions;

public class path_sum_iii {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        
        return pathSumCheck(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathSumCheck(TreeNode root, int sum){
        if(root == null) {
    		return 0;
    	}
    	
        //System.out.println(root.val + " " + sum);
    	if(sum - root.val == 0) {
            //System.out.println("Count++");
    		return 1 + pathSumCheck(root.left, 0) + pathSumCheck(root.right, 0);
    	}
        
        return pathSumCheck(root.left, sum - root.val) + pathSumCheck(root.right, sum - root.val);
    }
}
