class Solution {
    
    
    public int numDecodings(String s) {
        
        // Use dp to solve this
        
        int n = s.length();
        int mod = 1000000007;
        
        long dp[] = new long[n+1];   // some values may cause overflow in integer
        
        // Base Case
        
        dp[0] = 1;   // from 0 char, 1 combination counted
        dp[1] = decodeOneChar(s.charAt(0));
        
        // Fill dp array
        
        for (int i = 1; i < n; i++) {
            
            long includeOneCharWays = decodeOneChar (s.charAt(i)) * dp[i];
            
            long includeTwoCharWays = decodeTwoChars (s.charAt(i-1), s.charAt(i)) * dp[i - 1];
            
            dp[i + 1] = ( includeOneCharWays % mod + includeTwoCharWays % mod ) % mod;
            
        }
        
        return (int) dp[n];
                
    }
    
    
    // No. of ways to decode with 1 char
    
    private long decodeOneChar (char ch) {
        
        // If it is '*', no of ways are 9
        // If 0, then neither 0 counted nor 06 counted, so 0
        // If from 1-9, then 1 way for that particular number
        
        return (ch == '*') ? 9 : (ch != '0') ? 1 : 0;
        
    }
        
    // No. of ways to decode with 2 chars
    
    private long decodeTwoChars (char a, char b) {
        
        // If it is '*', no of ways are 9
        // If 0, then neither 0 counted nor 06 counted, so 0
        // If from 1-9, then 1 way for that particular number
        
        if (a == '*' && b == '*') {
            
            /* a and b both can take values from [1,9]
               So values can be:
               
               11 12 13 14 15 16 17 18 19
               21 22 23 24 25 26 27 28 29
               31 32 33 34 35 36 37 38 39
               ...
               91 92 93 94 95 96 97 97 99
               
               Total values can be 9*9 = 81
               
               But decoded values availale for A to Z  means 1 to 26
               So only below values counted:
               
               11 12 13 14 15 16 17 18 19   -> 9
               21 22 23 24 25 26            -> 6
               
            */
            
            return 15;
            
        } else if (a == '*') { 
            
            /* Total [ab]: 1b 2b 3b 4b 5b 6b 7b 8b 9b  =  81
            
               For b less than equal to 6,  below values are counted
            
                eg: 1b and 2b => 16 and 26.   ( Rest of them > 26 )
               
               Else
               
                eg: 1b => 18    (Rest of them > 26)
            */
            
            return b <= '6' ? 2 : 1;
            
        } else if (b == '*') {  
            
            /* Total [ab]: a1 a2 a3 a4 a5 a6 a7 a8 a9  =  81
            
               For a = 1, below 9 values are counted
            
                11 12 13 14 15 16 17 18 19
               
               For a = 2, below 6 values are counted
            
                21 22 23 24 25 26
                
               Else 0 -> (Rest of them > 26)
               
            */
            
            return (a == '1') ? 9 : (a == '2') ? 6 : 0;
            
        } else {
            
            // If no * present and only digits are there, just check if from 10 to 26, count it.
            
            int digitVal = Integer.valueOf("" + a + b);
            return (10 <= digitVal && digitVal <= 26) ? 1 : 0;
            
        }
        
    }
    
    
}
