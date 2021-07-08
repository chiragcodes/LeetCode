class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        
        // This is basically same as Longest Common SubString dp problem
        
        int m = nums1.length;
        int n = nums2.length;
        
        int maxLen = 0;
        
        int dp[][] = new int[m+1][n+1];
        
        // Bases Cases: When i=0 or j=0, dp[i][j] = 0, already its 0 by default
        
        for (int i = 1; i < m + 1; i++) {
            
            for (int j = 1; j < n + 1; j++) {
                
                // If prev value same, means the subarray is going on, so count it + 1
                // Else, it should be 0, which is by default
                
                if ( nums1[i - 1] == nums2[j - 1] ) {
                    
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                    maxLen = Math.max(maxLen, dp[i][j]);
                    
                }
                
            }
            
        }
        
        return maxLen;
        
    }
}
