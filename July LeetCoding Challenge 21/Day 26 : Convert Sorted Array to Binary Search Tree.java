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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        // Recursive Approach
        
        if (nums.length == 0) {
            
            return null;
            
        }
        
        int n = nums.length;
        
        TreeNode root = recHelper (nums, 0, n - 1);

        return root;
        
    }
    
    
    public TreeNode recHelper (int nums[], int low, int high) {
        
        if (low > high) {
            
            return null;
            
        }
        
        int mid = (low + high) / 2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = recHelper (nums, low, mid - 1);
        node.right = recHelper (nums, mid + 1, high);
        
        return node;
        
    }
    
    
}
