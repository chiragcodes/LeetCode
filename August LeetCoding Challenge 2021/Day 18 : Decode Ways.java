class Solution {
    
    public int numDecodings (String s) {
        
        
        int n = s.length();
        
        if (n == 0) {
            return 0;   // If decoding string length is 0, return 0
        }
        
        if (s.charAt(0) == '0') {
            return 0;   // If decoding string starts with 0, then invalid string, return 0
        }
        
        
        // r2: decode ways of s[i-2] , r1: decode ways of s[i-1] 
        
        int r1 = 1, r2 = 1;
    
        for (int i = 1; i < n; i++) {
            
            // zero voids ways of the last because zero cannot be used separately
            
            if (s.charAt(i) == '0') {
                r1 = 0;
            }

            // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
            
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                
                r1 = r2 + r1;
                r2 = r1 - r2;
                
            } else {
                
                r2 = r1;   // one-digit letter, no new way added
                
            }
            
        }

        return r1;
        
    }
}
