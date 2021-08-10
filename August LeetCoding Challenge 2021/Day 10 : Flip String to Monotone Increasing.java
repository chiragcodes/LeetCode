class Solution {
    
    public int minFlipsMonoIncr (String s) {
        
        /*  Reference:
        
            https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/189751/C%2B%2B-one-pass-DP-solution-0ms-O(n)-or-O(1)-one-line-with-explaination.
            
            https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/183896/Prefix-Suffix-Java-O(N)-One-Pass-Solution-Space-O(1)
            
            https://leetcode.com/problems/flip-string-to-monotone-increasing/discuss/183851/C%2B%2BJava-4-lines-O(n)-or-O(1)-DP
        
        */
        
        int count1s  = 0;
        int countFlips = 0;
        
        for (char ch : s.toCharArray()) {
            
            if (ch == '1') {
                
                count1s++;
                
            } else {
                
                countFlips++;
                
            }
            
            // count1s have count of 1s till now. If that is min, means flip all that 1s to 0s.
            
            //  eg:  000 1 00 11 000 1 0000....  , if rolling count of 1s is less, than try to flip that 1s
            
            //  eg:  000 1 00 11 000 1 0000 1111 00 1111111 .... , if rolling count of 1s is more, flip 0s 
            
            countFlips = Math.min (count1s, countFlips);
            
        }
        
        return countFlips;
        
        
    }
}
