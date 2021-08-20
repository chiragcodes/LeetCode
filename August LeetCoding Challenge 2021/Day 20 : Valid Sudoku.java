class Solution {
    
    public boolean isValidSudoku(char[][] board) {

        
        int m = board.length, n = board[0].length;
        
        Set <String> set = new HashSet <> ();
        
        for (int row = 0; row < m; row++) {
            
            for (int col = 0; col < n; col++) {
                
                char number = board[row][col];
                
                if (number != '.') {
                    
                    int block = (row / 3 * 3) + (col / 3);
                    
                    if (set.contains("r" + row + number) || 
                        set.contains("c" + col + number) ||
                        set.contains("b" + block + number)) {
                        
                        return false;
                        
                    } else {
                        
                        set.add("r" + row + number);
                        set.add("c" + col + number);
                        set.add("b" + block + number);
                        
                    }  
                    
                }
                
            }
            
        }
        
        return true;
        
        
    }
}
