/*. Approach: DFS + Binary Search
        
    Observation: 
            
        1. grid[i][j] values lies between 0 to n*n-1 (given in constraint).
           
           So, water rise will be in range (0, n*n-1). 
           So, our result (minimum time to reach) will be in this fixed range (grid[0][0], n*n-1).
           (When we are at grid[0][0], we cannot move till Time T reaches grid[0][0] value, so it is min.)
               
        2. If we can reach from point a(i,j) to b(k,l) in time T, then we can reach in time T+1 also.
               
            eg: if we able to reach some point at 5th sec, then I can reach in 6,7,8... time also.

             If I store this in some boolean array, it will be like below: 

              { false, false, false, ..., false, true, true, true, ..., true}
                                                        -     -     -          -
           Idea is to use Binary Search to check at any T, if my answer is possible.
            -> If its possible in time T, check for less time than T
            -> If its not possible in time T, check for more time than T
                
           Do this, until we are left out with only 1 element, and that would be the 1st 'True'.
           
           ( Note: We can also do linear traversal like checking from time T = n*n-1 to 0 for the result.
             But Binary Search would be efficient as it is sorted based on false/true
           )
        
        
*/


class Solution {
    
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        
        int low = grid[0][0];   // min time needed is 1st square where we stand, we cannot move till T reaches grid[0][0]
        int high = n*n - 1;     // max time needed is the max value present in grid (provided in constraint)
        
        
        // Apply Binary Search for checking if possile result lies in the intervals.
        
        while (low < high) {
            
            int mid = low + ((high - low) >> 1);
            
            // Start search from grid[0][0] 
            
            /* Note:

               Create boolean visited array in while loop as we want new search everytime for particular time T.
               
                Otherwise, when we are searching for range (0,24) it will make some squares visited.
                So, next time for checking dfs for range (0,12) or (13,24) it will not check those squares.
                
                So, write code for creating a new boolean array in while loop, but not before while loop.
              
            */
            
            boolean visited[][] = new boolean[n][n];
            
            if (dfs(grid, 0, 0, mid, visited)) {
                
                high = mid;
                
            } else {
                
                low = mid + 1;
                
            }
            
        }
        
        return low;
        
    }
    
    
    // DFS function to check if solution exists for given time T
    
    private boolean dfs (int grid[][], int row, int col, int time, boolean visited[][]) {
        
        int n = grid.length;
        
        // Corner Cases / Exit Return cases / Solution not possible
        
        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] > time) {
            
            return false;   // If current square elevation > T, then wait till time for that elevation.
            
        }
        
        visited[row][col] = true;         // Mark the square as visited
        
        if (row == n-1 && col == n-1) {
            return true;                  // Return true, as for some DFS, result is obtained.
        }
        
        // Check for other 4 directional scenarios and return true if Any of them is true.
        
        return dfs(grid, row - 1, col    , time, visited) || 
               dfs(grid, row + 1, col    , time, visited) ||
               dfs(grid, row    , col - 1, time, visited) || 
               dfs(grid, row    , col + 1, time, visited);
        
    }
    
    
    
}
