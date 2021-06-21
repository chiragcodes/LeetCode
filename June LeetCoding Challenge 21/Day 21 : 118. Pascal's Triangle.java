class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        
        
        /*  Approach:  Use loops to create this pattern   */
        
        /* 
           Observation:
           
           1. Every time, the no of elements in row increases, So, for row number n, there are n elements in that row.
           2. Corner element is always 1 (both and left and right side)
           3. Middle elements can easily be found by sum of above two elements on it.
           
        */
        
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();  // Create Result List
        
        
        /* Add 1st row element in result list */
        
        List<Integer> row0 = new ArrayList<Integer>(Arrays.asList(1));
        res.add(row0);
        
        
        /* Traverse for row elements from 2 to n */
        
        for (int row = 1; row < numRows; row++) {
            
            List<Integer> list = new ArrayList<Integer>();
            
            
            
            // Add 1 for the leftmost corner
            
            list.add(1);
            
            // Calculate middle elements for current row (excluding corners 0 and n-1)
            
            for (int col = 1; col < row; col++) {
                list.add(res.get(row - 1).get(col - 1) + res.get(row - 1).get(col));
            }
            
            // Add 1 for the rightmost corner
            
            list.add(1);
                
            
            
            // Add current row to the final list
                
            res.add(list);
            
        }
        
        
    return res;
        
    }
}
