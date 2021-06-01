class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length; // row size
        int n = grid[0].length; // col size
        
        int area = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                area = Math.max(area, dfs(i,j,grid));
            }
        }
        
        return area;
    }
    
    public int dfs(int i, int j, int[][] grid) {
        
        // If row/col index out of range of grid
        if (i<0 || j<0 || i>=grid.length || j>=grid[i].length) {
            return 0;
        }
        // If cell value is 0
        if (grid[i][j] != 1) {
            return 0;
        }
        
        // Mark the cell as visited by updating value to 5
        grid[i][j] = 5;
        
        // Return the sum of 4 directions
        return 1 + (
               dfs(i-1,j,grid) + dfs(i+1,j,grid) + dfs(i,j-1,grid) + dfs(i,j+1,grid)
        );
    }
    
}
