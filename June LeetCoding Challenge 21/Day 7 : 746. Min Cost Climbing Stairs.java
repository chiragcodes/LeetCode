class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        
    
        /*  Bottom Up Approach 
        
            dp[n-1] = cost[n-1];     dp[n-2] = cost[n-2];
            
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);    i : n-3 -> 0.
        
        
            Example:
            
            cost =   [ 1,  100,  1,  1,  1,  100,  1,  1,  100,  1 ]       Output = 6. 
            
            DP   =   [ 0,   0 ,  0,  0,  0,   0 ,  0,  0,   0 ,  0 ]
            
                       -    -    -   -   -    -    -   -   100   1
                                                           
                       -    -    -   -   -    -    -   2    -    -         : 1 + min (100, 1)
                       
                       -    -    -   -   -    -    3   -    -    -         : 1 + min (2, 100)
                       
                       -    -    -   -   -   102   -   -    -    -         : 100 + min (3, 2)
                       
                       -    -    -   -   4    -    -   -    -    -         : 1 + min (102, 3)
                       
                       -    -    -   5   -    -    -   -    -    -         : 1 + min (4, 102)
                       
                       -    -    5   -   -    -    -   -    -    -         : 1 + min (5, 4)
                       
                       -   105   -   -   -    -    -   -    -    -         : 100 + min (5, 5)
                       
                       6    -    -   -   -    -    -   -    -    -         : 1 + min (105, 5)


                  Min (6, 105) = 6
                                === 
                    
        
        */

        int n = cost.length;
        int dp[] = new int[n];
        
        // Store the values of last 2 paths

        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];
        
        // Bottom up approach for couting min steps from ith floor to top floor
           // Every ith value will represent min cost to go from ith floor to top floor if ith floor is counted.
        
        for (int i = n-3; i>=0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        
        // We can start from floor 0 or 1, check from which cost will be less.
        
        return Math.min(dp[0], dp[1]);
        
        
        
        
        /*  Similar Top Down Approach
        
            dp[0] = cost[0];     dp[1] = cost[1];
            
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);     i : 2 -> n-1.
        
        */
        
        
        
    }
    
}
