class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        /*  Reference: https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution */
        
        
        if (strs == null || strs.length == 0) {
            
            return new ArrayList<>();
            
        }
        
        
        Map <String, List<String>> map = new HashMap<>();
        
        
        for (String str : strs) {     // str = "eat"
            
            char arr[] = new char[26];  // arr[] = [ 0 0 0 0 ... 0]
            
            for (char ch : str.toCharArray()) {
                                       //           a       e           t
                arr[ch - 'a']++;       // arr[] = [ 1 0 0 0 1 0 0 ... 0 1 0 .. 0 ]
                
            }
            
            /*  Instead of lines 21 to 27, can use below two lines also. It will sort, above will count.
            
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            
            */
            
            String sortedStr = String.valueOf(arr);
            
            
            if ( ! map.containsKey(sortedStr) ) {
                
                map.put(sortedStr, new ArrayList<>());
                
            }
            
            map.get(sortedStr).add(str);
            
        }
        
        
        return new ArrayList<>(map.values());
        
        
    }
}
