class Solution {
    
    public int trap(int[] height) {
        
        
        /* 
        
        Good Post:
        - https://leetcode.com/problems/trapping-rain-water/discuss/153992/Java-O(n)-time-and-O(1)-space-(with-explanations).
        
        Good Comment in Post:
        - https://leetcode.com/problems/trapping-rain-water/discuss/17391/Share-my-short-solution.
        
        */
        
        int n = height.length;
        
        if (n <= 2) {
            
            return 0;
            
        }
        
        int leftMax = height[0];
        int rightMax = height[n-1];
        
        int water = 0, left = 1, right = n-2;
        
        while (left <= right) {
            
            if (leftMax <= rightMax) {
                
                leftMax = Math.max(leftMax, height[left]);
                water = water + (leftMax - height[left]);
                left++;
                
            } else {
                
                rightMax = Math.max(rightMax, height[right]);
                water = water + (rightMax - height[right]);
                right--;
                
            }
            
        }
        
        return water;
        
    }
}
