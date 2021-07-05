class Solution {
    
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        
        // Check if size of both matrix is same or not, else return given matrix
        
        int m = mat.length, n = mat[0].length;
        
        
        if (m*n != r*c) {
            
            return mat;    // Return original matrix if size of ip and op matrix is different
            
        }
        
        
        int reshape[][] = new int[r][c];
        
        // For all values to be filled in output matrix in sequential manner
        
        for (int i = 0; i < r*c; i++) {
             
            //  i/c and i/n denotes the row no. i%c and i%n denotes the col no.
            
            reshape [i / c] [i % c]  =  mat [i / n] [i % n]; 
            
        }
        
        
        return reshape;
        
    }
}
