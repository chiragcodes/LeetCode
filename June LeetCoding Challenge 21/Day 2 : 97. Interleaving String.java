class Solution {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        /* String s3 should contains all strings of s1 and s2 and in proper order of s1 and s2 */
        
        if (s3.length() != s1.length() + s2.length()) {
            // length (s3) should be length (s1) +  length (s2)
            return false;
        }
        
        if (s3.length() == 0 && s2.length() == 0 && s1.length() == 0) {
            // All strings are empty, so s3 = s1 + s2
            return true;
        }
        
        int dp[][] = new int[s1.length()][s2.length()];
        // Initializing dp array with -1 (not calculated)
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        // Use recursion along with memorization dp
        if (recHelper(s1, s2, s3, dp, 0, 0, 0) == 1) {
            return true;
        } else {
            return false;
        }
             
    }
    
    public static int recHelper (String s1, String s2, String s3, int[][] dp, int i, int j, int k) {
        
        /* 3 Base cases related to length of strings */
        
        // k reaches length of String s3 => s3 is fully used
        if (s3.length() == k) {
            return 0;
        }
        
        // i reaches till length of String s1 => s1 is fully used
        if (s1.length() == i) {
            // So, remaining strings of s2 and s3 should be same
            return s2.substring(j).equals(s3.substring(k)) ? 1 : 0;
        }
        
        // j reaches till length of String s2 => s2 is fully used
        if (s2.length() == j) {
            // So, remaining strings of s1 and s3 should be same
            return s1.substring(i).equals(s3.substring(k)) ? 1 : 0;
        }
        
        // If the value is already calculated, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        /* 2 Recursion cases related to character matched */
        
        int recS1 = 0, recS2 = 0;
        
        // Current char of s1 and s3 are same
        if (s1.charAt(i) == s3.charAt(k)) {
            // Recur for next chars of s1/s3 and curr char of s2
            recS1 = recHelper(s1, s2, s3, dp, i+1, j, k+1);
        }
        
        // Current char of s2 and s3 are same
        if (s2.charAt(j) == s3.charAt(k)) {
            // Recur for next chars of s2/s3 and curr char of s1
            recS2 = recHelper(s1, s2, s3, dp, i, j+1, k+1);
        }
        
        // stores the value: If any of them returns 1, set 1. Else 0.
        dp[i][j] = Math.max(recS1, recS2); 
        
        return dp[i][j];
        
    }
    
    
}
