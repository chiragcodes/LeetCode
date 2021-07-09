class Solution {
    
    public int lengthOfLIS(int[] nums) {
        
        
        /*  Use 1 dimension dp array for solving this :-  TC = O(N ^ 2)  SC = O(N)  */
        
        // Return Case: If array is null or length of array is 0
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        
        // Base Case: Fill 1s in all, as min LCS will be 1 as len of array is > 0
        
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        int maxLen = 1;
        
        for (int i = 1; i < n; i++) {
            
            for (int j = 0; j < i; j++) {
                
                // If curr element is more than any of the prev one, (add 1 to that prev count / curr max)
                
                if (nums[i] > nums[j]) {
                    
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    
                } 
                
            }
            
          maxLen = Math.max(maxLen, dp[i]);
            
        }
        
       return maxLen;
           
    }
}

/* 
   Note: Can be done in nlogn also:
   https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

*/
