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
    
    // hashmap object so that can be used in recursive methods
    
    HashMap<Integer,Integer> map = new HashMap<>();
    int count = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = inorder.length;   // overall length of final TreeNode
        
        for (int i=0; i<n; i++) {
            map.put(inorder[i], i);  // store the inorder traversal elements with its index in map.
        }
        
        return dfs(0, n-1, preorder);
    
    }
    
    TreeNode dfs(int left, int right, int[] preorder) {
        
        // Base Exit condition
        if (left > right) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[count++]);
        
        int mid = map.get(root.val);  // identify the root index
        
        // create it's left and right subtree
        
        root.left = dfs(left, mid-1, preorder);
        root.right = dfs(mid+1, right, preorder);
        
        return root;
    }
    
    
    
}
