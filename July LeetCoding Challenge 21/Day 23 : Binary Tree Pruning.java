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
    
    public TreeNode pruneTree(TreeNode root) {
        
        /* 
        
        Good Post with same logic : 
        
        In interview, use below post's code. (using different function for removing the subtree)
        
        https://leetcode.com/problems/binary-tree-pruning/discuss/148533/Java-Backtracking-with-O(N)-time-complexity
        
        */
        
        
        // Using Recursion. TC = O(N), SC = O(1) as using same inplace tree changes
        
        if (root == null) {
            
            return null;  // If root is null, return null
            
        }
        
        // assign left subtree as (either assign same subtree or updated subtree with removing some nodes)
        root.left = pruneTree (root.left);
        
        // assign right subtree as (either assign same subtree or updated subtree with removing some nodes)
        root.right = pruneTree (root.right); 
        
        
        // If subtree's value is 0 and is the leaf node, then there cannot be 1 below it, so return null.
        if (root.left == null && root.right == null && root.val == 0) {
            
            return null;
            
        }
        
        return root;        
        
    }
}
