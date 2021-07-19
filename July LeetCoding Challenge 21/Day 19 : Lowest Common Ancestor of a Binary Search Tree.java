/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {
            
            // In BST, if both p and q are less than current value, then check on left side of root. Else check right side if both are greater.
            
            if ( root.val > p.val && root.val > q.val ) {
                
                root = root.left;
                
            } else if ( root.val < p.val && root.val < q.val ) {
                
                root = root.right;
                
            } else {
                
                return root;
                
            }
                
        }   
        
        return root;
        
    }
}
