class Solution {
    
    public String pushDominoes(String dominoes) {
        
        /* Helpful Posts
        
        https://leetcode.com/problems/push-dominoes/discuss/132332/JavaC%2B%2BPython-Two-Pointers
        https://leetcode.com/problems/push-dominoes/discuss/132482/Java-one-pass-in-place-13ms
        
        */
        
        
        int n = dominoes.length();
        char arr[] = dominoes.toCharArray();
        
        int L = -1, R = -1;  // last seen L and R positions initialize to -1
        
        // Iterate through the dominoes 
        
        for (int i = 0; i <= n; i++) {
            
            if (i == n || arr[i] == 'R') {
                
                if (R > L) {   // R ... R , then turn all to R
                    
                    // Last seen R was moving right, curr R is moving right. So, make prev -> curr all right.
                    
                    while (R < i) {
                        
                        arr[R] = 'R';
                        R++;
                        
                    }
                    
                }
                
                R = i;   // make Last seen R to curr position
                
            } else if (arr[i] == 'L') {
                
                if (L > R || (R == -1 && L == -1)) {   // L ... L , then turn all to L
                    
                    // Last seen L was moving left, curr L is moving left. So, make prev -> curr all left.
                    
                    while (++L < i) {
                        
                        arr[L] = 'L';
                        // L++;
                        
                    }
                    
                } else {  // R ... L
                    
                    L = i;  // Make current as L
                    
                    int low = R + 1, high = L - 1;
                    
                    // Last seen was R, curr is L. from left -> mark L. from right -> mark R.
                    
                    while (low < high) {   // The middle element will stay as is '.'
                        
                        arr[low++] = 'R';
                        arr[high--] = 'L';
                        
                    }
                    
                }
                
            }
            
        }
        
        return new String(arr);
        
    }
}
