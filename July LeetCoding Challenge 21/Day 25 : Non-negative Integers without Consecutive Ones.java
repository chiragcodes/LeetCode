class Solution {
    
    public int findIntegers(int n) {
        
        // Good Post : https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/discuss/103749/Java-Solution-DP
        
        // https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/discuss/103751/Java-O(1)-time-O(1)-space-DP-Solution
        
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int m = sb.length();
        
        int p[] = new int[m];
        int q[] = new int[m];
        
        p[0] = 1;  // base cases
        q[0] = 1;  // bases cases
        
        // Use dp for filling this
        
        for (int i = 1; i < m; i++) {
            
            p[i] = p[i - 1] + q[i - 1];    
            q[i] = p[i - 1];
            
        }
        
        int res = p[m - 1] + q[m - 1];
        
        for (int i = m - 2; i >= 0; i--) {
            
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') {
                
                break;
                
            }
            
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') {
                
                res = res - q[i];
                
            }
            
        }
        
        
        
        return res;
        
    }
}
