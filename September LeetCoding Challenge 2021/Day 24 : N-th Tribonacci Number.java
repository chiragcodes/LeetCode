class Solution {
    
    public int tribonacci(int n) {
        
        
        // T(n) = T(n-1) + T(n-2) + T(n-3)
        
        if (n == 0) {
            return 0;
        } 
        
        if (n == 1 || n == 2) {
            return 1;
        }
        
        // p1 refers to T(n-1) , p2 to T(n-2) , p3 to T(n-3)
        
        int p1 = 1, p2 = 1, p3 = 0;
        
        int res = 0;
        
        for (int i = 3; i <= n; i++) {
            
            res = p1 + p2 + p3;
            
            p3 = p2;
            p2 = p1;
            p1 = res;
            
        }
        
        return res;
        
    }
}
