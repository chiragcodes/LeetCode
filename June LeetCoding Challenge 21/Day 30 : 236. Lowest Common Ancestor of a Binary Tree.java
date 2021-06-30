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
        
        
        // Base or return case
        
        if (root == null) {
            
            return null;   // If this node is null, return null.
            
        }
        
        if (root == p || root == q) {
            
            return root;  // If p or q found at this subnode, return this subnode
            
        }
                
        
        // Check for p and q on left and right sub tree
        
        TreeNode leftSubTree = lowestCommonAncestor(root.left, p, q);
        
        TreeNode rightSubTree = lowestCommonAncestor(root.right, p, q);
        
        
        // If p or q not found, return -1. (As per constraint, this case will not occur)
        
        if (leftSubTree == null && rightSubTree == null) {
            
            return null;
            
        }
        
        // If p and q found in both the sub trees, then their parent contains them both
        
        if (leftSubTree != null && rightSubTree != null) {
            
            return root; 
            
        }
        
        // Else return subtree which contains both p and q
        
        return leftSubTree != null ? leftSubTree : rightSubTree;
        
        
        
    }
}
