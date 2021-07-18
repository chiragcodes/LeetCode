class Solution {
    
    public int stoneGameVII(int[] stones) {
        
        /*  We can do it by recursion. We will do it using 1D dp array */
        
        int n = stones.length;
        int dp[] = new int[n];
        
        // Bottom up Approach
        
        for (int i = n-1; i >= 0; i--) {
            
            int prevStone = 0, currStone = 0;
            int sum = stones[i];
            
            // For every range between i+1 to n
            
            for (int j = i+1; j < n; j++) {
                
                currStone = dp[j];
                
                // Store sum from index i till j (sum of ith index is stored in ith loop.)
                sum = sum + stones[j];
                
                int ignoreRightCorner = sum - stones[j];  // remove rightmost stone in range
                int ignoreLeftCorner = sum - stones[i];  // remove leftmost  stone in range
                
                // Store count in jth index as max of below two conditions
                dp[j] = Math.max(ignoreRightCorner - prevStone, ignoreLeftCorner - currStone); 
                    
                // Store curr stone as previous stone for next iteration.
                prevStone = dp[j];
                
            }
            
        }
        
        return dp[n-1];
        
    }
}
