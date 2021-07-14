class Solution {
    
    public String customSortString(String order, String str) {
        
        
        /*  
            Keep a count or bucket array to store count/order of elements in order array
            T.C.  O(order + str)  
        
        */
        
        int count[] = new int[26];
        
        // Store counts of the characters in str string
        
        for (char ch : str.toCharArray()) {
            
            count[ch - 'a']++;
            
        }
        
        // For every ordered element present in order string, append it in result the times it occur in str
        
        StringBuilder res = new StringBuilder();
        
        for (char ch : order.toCharArray()) {
            
            while (count[ch - 'a'] > 0) {
                
                res.append(ch);
                count[ch - 'a']--;
                
            }
            
        }
        
        // Append the rest of the chars present in str string and not in order string
           // Till now, all the chars present in order have count = 0
              // So, elements remaining with count > 0 are rest of the elements not present in order str.
        
        for (int i = 0; i < count.length; i++) {
            
            while (count[i] > 0) {
                
                res.append((char)(i + 'a'));
                count[i]--;
            }
            
        }
        
        return res.toString();
        
    }
}
