class Solution {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        
        /*  Approach: Use TreeSet  */
        
        
        int m = matrix.length;     // row
        int n = matrix[0].length;  // col
        
        int ans = Integer.MIN_VALUE;
        
        
        // Check for all combinations of cols from 0 to n
        
        for (int i = 0; i < n; i++) {
            
            int sum[] = new int[m];  // create prefix sum row
            
            // Check for current combination of col j to n
            
            for (int j = i; j < n; j++) {
                
                // Calculate prefix sum of row for that column
                
                for (int row = 0; row < m; row++) {
                    
                    sum[row] = sum[row] + matrix[row][j];
                
                }
                
                // Check the sum of rectangle for current combination prefix row sum
                
                int currSum = sumHelper(sum, k);
                ans = Math.max(ans, currSum);
                
            }
            
        }
        
        return ans;
        
    }
    
    
    
    // Calculate the difference in sum in O(logm) time
    
    private int sumHelper (int sum[], int k) {
     
        
        int ans = Integer.MIN_VALUE;
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        // Calculate prefix col sum of currently prefix row sum array
        
        int val = 0;
        
        for (int i=0; i<sum.length; i++) {
            
            // Row prefix sum and Col prefix sum till i stored in val
            
            val = val + sum[i];
            
            int diff = val - k;  // differnce between current row+col sum till i and given k
            
            Integer target = set.ceiling(diff); 
            
            if (target != null) {
                ans = Math.max(ans, val - target);
            }
            
            set.add(val);  
            
        }
        
        return ans;
        
    }
    
    
}
