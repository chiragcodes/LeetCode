class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        
        int n = matrix.length;
        
        // The lowest value will be at (0,0) at max value at (n-1,n-1) as row/col are sorted
        int low = matrix[0][0], high = matrix[n-1][n-1];
        
        // Perform Binary Search to find the no of elements less is k
        
        while (low <= high) {
            
            int mid = low + ((high - low)/2);
            
            int diff = countSmallerValues (mid, matrix);
            
            if (diff < k) {
                
                low = mid + 1;
                
            } else {
                
                high = mid - 1;
                
            }
            
        }
        
        return low;
        
    }
    
    /*  Function to return 
    
        If we start from bottom left, 
        if we want more, then only move right, if we want less, then only move left.
        
    */
    
    private static int countSmallerValues (int mid, int[][] matrix) {
        
        int n = matrix.length, count = 0;
        
        int i = n - 1, j = 0;
        
        while (i >= 0 && j <= n-1) {
            
            // currently consider at relatively bottom left
            
            if (matrix[i][j] <= mid) {
                
                count = count + (i + 1);  // count no of cols passed for this row in final count
                
                j++;   // Move right the col, if want more value
                
            } else {
                
                i--;   // Move up the row, if want less value
                
            }
            
        }
        
        return count;      
        
    }
    
    
}
