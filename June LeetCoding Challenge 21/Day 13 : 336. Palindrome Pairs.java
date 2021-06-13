class Solution {
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        /*. Brute Force can be to run two loops and checking every pair (i, j) and add to result. O(n2) */
        
        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();  // store the results in arraylist (return type)
        
        // Check all permutations of every pair
        
        for (int i=0; i<n; i++) {
            
            for (int j=i+1; j<n; j++) {
                
                // Check for every pair pa, pb -> Check if pa_pb/ pb_pa is palindrome, add them to results.
                
                if (checkPalindrome(words[i], words[j])) {
                    res.add(Arrays.asList(i, j));
                }
                
                if (checkPalindrome(words[j], words[i])) {
                    res.add(Arrays.asList(j, i));
                }
                
            }
            
        }
        
        return res;
    }
    
    
    // Helper function to check palindrome pair
    
    public boolean checkPalindrome (String w1, String w2) {
        
        int l1 = w1.length(), l2 = w2.length();
        int start = 0, end = l1 + l2 - 1;
        
        /*. Instead of concatenating the both the pairs of string and checking palindrome, which gives TLE
            We will use two pointers to travel from 0 to length of pair.
            If any time w1 ends, we will use curr index (start) - l1 (len of w1). It will give index of w2.
        */
        
        
        while (start < end) {
            
            char c1 = start < l1 ? w1.charAt(start) : w2.charAt(start - l1);
            char c2 = end  >= l1 ? w2.charAt(end - l1) : w1.charAt(end);
            
            if (c1 != c2) {
                return false;
            }
            
            start++;  end--;
            
        }
        
        return true;
        
    }
    
    
    
}
