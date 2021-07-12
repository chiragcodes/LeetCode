class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        
        /* 
            Use two maps consecutively of size 256 in one array of 512. 
            If there is mismatch between char/index and its mappedchar/index, return false
            Else return true is no mismatch till end of string
            
        */
        
        int map[] = new int[512];
        
        for (int i = 0; i < s.length(); i++) {
            
            if ( map[s.charAt(i)] != map[t.charAt(i) + 256] ) {
                
                return false;
                
            }
            
            map[s.charAt(i)] = i + 1;
            map[t.charAt(i) + 256] = i + 1;
            
        }
        
        return true;
        
    }
}
