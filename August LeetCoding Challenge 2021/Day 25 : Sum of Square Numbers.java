class Solution {
    
    public boolean judgeSquareSum (int c) {
        
        
        // Store the i^2 in the set. Check at any time its complement is present or not.
        
        HashSet <Integer> set = new HashSet <Integer>();
        
        for (int i = 0; i <= Math.sqrt(c); i++) {
            
            set.add (i * i);
            
            if (set.contains(c - i * i)) {
                return true;
            }
            
        }
        
        return false;
        
        
    }
}
