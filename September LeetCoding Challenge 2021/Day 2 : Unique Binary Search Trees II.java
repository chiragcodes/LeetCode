/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    
    public List <TreeNode> generateTrees (int n) {
        
        return generateSubtrees (1, n);
        
    }
    
    
    // Helper Divide and Conquer function
    
    private List<TreeNode> generateSubtrees (int start, int end) {
	
        List <TreeNode> res = new LinkedList <TreeNode>();
	
        if (start > end) {
            
		    res.add(null);
		    return res;
            
	    }

	    for (int i = start; i <= end; i++) {
		
            List<TreeNode> leftSubtrees = generateSubtrees (start, i - 1);
		    List<TreeNode> rightSubtrees = generateSubtrees (i + 1, end);

		    for (TreeNode left : leftSubtrees) {
                
			    for (TreeNode right : rightSubtrees) {
                    
				    TreeNode root = new TreeNode(i);
				    root.left = left;
				    root.right = right;
                    
				    res.add(root);
			    }
		    }
	    }
	
        return res;
    }
    
    
    
}
