
class Solution {
    
    public int N = 0;
    
    public int largestIsland(int[][] grid) {
        
        /* Good Posts
        
            https://leetcode.com/problems/making-a-large-island/discuss/127032/C%2B%2BJavaPython-Straight-Forward-O(N2)-with-Explanations
            
            https://leetcode.com/problems/making-a-large-island/discuss/127256/DFS-JAVA-AC-CONCISE-SOLUTION
        
            https://leetcode.com/problems/making-a-large-island/discuss/126960/Extremely-Simple-Concept-Using-Marker
            
        */
        
        N = grid.length;
        
        // Use DFS for every island and assign it an index of island
        
        int index = 3, res = 0;
        
        HashMap<Integer, Integer> area = new HashMap<>();
        
        for (int x = 0; x < N; x++) {
            
            for (int y = 0; y < N; y++) {
                
                if (grid[x][y] == 1) {
                    
                    area.put(index, dfs(grid, x, y, index));
                    res = Math.max(res, area.get(index++));
                    
                }
                
            }
            
        }
                    

        // Check every 0 cell and count biggest island it can connect
        
        for (int x = 0; x < N; x++) {
            
            for (int y = 0; y < N; y++) {
                
                if (grid[x][y] == 0) {
                    
                    HashSet<Integer> seen = new HashSet<>();
                    
                    int curr = 1;
                
                    for (Pair<Integer, Integer> p : move(x, y)) {
                        
                        index = grid[p.getKey()][p.getValue()];
                       
                        if (index > 1 && !seen.contains(index)) {
                            seen.add(index);
                            curr += area.get(index);
                        }
                        
                    }
                    
                    res = Math.max(res, curr);
                }
                
            }
            
        }
        
            
        return res;
        
    }
    
    
    public List <Pair<Integer, Integer>> move (int x, int y) {
        
        ArrayList <Pair<Integer, Integer>> list = new ArrayList<>();
        
        if ( isValid (x, y + 1) ) {
            
            list.add(new Pair<Integer, Integer> (x, y + 1));
            
        }
        
        if ( isValid (x, y - 1) ) {
            
            list.add(new Pair<Integer, Integer> (x, y - 1));
            
        }
        
        if ( isValid (x + 1, y) ) {
            
            list.add(new Pair<Integer, Integer> (x + 1, y));
            
        }
        
        if ( isValid (x - 1, y) ) {
            
            list.add(new Pair<Integer, Integer> (x - 1, y));
            
        }
        
        return list;
        
    }
    
    
    
    public boolean isValid (int x, int y) {
        
        // the cells x and y are inside valid rows and cols range or not
        
        return x >= 0 && x < N && y >= 0 && y < N;
        
    }
    
    
    public int dfs (int grid[][], int x, int y, int index) {
        
        int area = 0;
        
        grid[x][y] = index;
        
        for (Pair <Integer, Integer> p : move(x, y)) {
            
            if (grid[p.getKey()][p.getValue()] == 1) {
                
                area += dfs(grid, p.getKey(), p.getValue(), index);
                
            }
            
        }
        
        return area + 1;
        
    }

    

    
}
