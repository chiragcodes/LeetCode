class Solution {
    
    public int countVowelPermutation(int n) {
        
        
        /*  Approach:
        
             dp[n+1][b] = sum of all possible dp[n][a] where there is directed edge from a to b.
        
        */
        
        // dp[i][j] := a string of length 'i' ends with a vowel represented by index 'j'
        
        long dp[][] = new long[n+1][5];
        
        // For length n = 1, there will be 5 strings consisting of the given 5 vowels
        
        for (int i=0; i<5; i++) {
            
            dp[1][i] = 1;
        
        }
        
        
        /* 
            vowels and index mapping
               
            0: a -> e             [a is followed by e, After a, e is possible]
            1: e -> a, i
            2: i -> a, e, o, u
            3: o -> i, u
            4: u -> a
            
            So, 
            
            0: a <- e, i, u             [a can follow e, Before e / i / u, a is possible]
            1: e <- a, i
            2: i <- e, o
            3: o <- i
            4: u <- i, o
            
        */
        
        int m = 1000000007;
        
        for (int i = 2; i < n+1; i++) {
            
            dp[i][0] = ( dp[i-1][1] + dp[i-1][2] + dp[i-1][4] ) % m;
            
            dp[i][1] = ( dp[i-1][0] + dp[i-1][2]              ) % m;
            
            dp[i][2] = ( dp[i-1][1] + dp[i-1][3]              ) % m;
            
            dp[i][3] = ( dp[i-1][2]                           ) % m;
            
            dp[i][4] = ( dp[i-1][2] + dp[i-1][3]              ) % m;
                        
        }
        
        
        long count = 0;
        
        for (int i=0; i<5; i++) {
            
            count = ( count + dp[n][i] ) % m;
            
        }

        return (int) count;
        
        
    }
}
