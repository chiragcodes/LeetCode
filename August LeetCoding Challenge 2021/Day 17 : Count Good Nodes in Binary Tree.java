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
    
    public int goodNodes (TreeNode root) {
        
        // any random value -10000, then onwards pass value of root
        
        return goodNodes(root, -10000);
        
    }
    
    
    public int goodNodes (TreeNode root, int val) {
        
        if (root == null) return 0;
        
        int res = root.val >= val ? 1 : 0;
        
        res += goodNodes (root.left,  Math.max(val, root.val));
        res += goodNodes (root.right, Math.max(val, root.val));
        
        return res;
        
    }
    
}
