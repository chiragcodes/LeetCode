class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        
        /* Good Post
        
            https://leetcode.com/problems/01-matrix/discuss/101021/Java-Solution-BFS
            
            https://leetcode.com/problems/01-matrix/discuss/101060/Java-DFS-solution-beat-95
        
        */
        
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            
            for (int j =0; j < n; j++) {
                
                if (mat[i][j] == 0) {
                    
                    // If value is itself 0, then min distance is also 0. 
                    // For new entry created (i, j), the default value is 0
                    
                    queue.offer(new int[] {i, j});
                    
                } else {
                    
                    // By default, set value as max if the value is 1. Then update accordingly.
                    
                    mat[i][j] = Integer.MAX_VALUE;
                    
                }
                
            }
            
        }

        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            
            int cell[] = queue.poll();
            
            // Check for all 4 directions, if in ques can move in diagonals, then just change dirs array
            
            for (int d[] : dirs) {
                
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                
                // If at any time, the new value is not proving better results, ignore and continue
                
                if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] <= mat[cell[0]][cell[1]] + 1) {
                    
                    continue;
                    
                }
                
                // Add this new cell in queue and assign the value 1 + current value to it.
                
                queue.add(new int[] {r, c});
                
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
                
            }
            
        }
        
        return mat;
        
        
    }
}
