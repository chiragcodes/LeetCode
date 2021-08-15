class Solution {
    
    public String minWindow(String s, String t) {
        
        
        if ( s == null || s.length() == 0 || s.length() < t.length() ) {
            
            return "";  // res not possible for these cases
            
        }
        
        
        // Store freq of every char in String t in map
        
        HashMap <Character, Integer> map = new HashMap < Character, Integer > ();
        
        for (char ch : t.toCharArray()) {
            
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
            
        }
        
        
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        
        int count = 0;
        
        
        // For every char in String s
        
        for (int right = 0; right < s.length(); right++) {
            
            // If the char in S present in char in T
            
            if (map.containsKey(s.charAt(right))) {
                
                // Reduce the char's freq and increment count
                
                map.put (s.charAt(right), map.get(s.charAt(right)) - 1);
                
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                
                // If common chars reaches string T length
                
                while (count == t.length()) {
                    
                    if (right - left + 1 < minLen) {
                    
                        minLeft = left;
                        minLen = right - left + 1;
                
                    }
                
                    if (map.containsKey(s.charAt(left))) {
                    
                        map.put (s.charAt(left), map.get(s.charAt(left)) + 1);
                        
                        if(map.get(s.charAt(left)) > 0) {
                            count --;
                        }
                    
                    }
                    
                    left++;
                    
                }
                
                
            }
            
        }
        
        
        
        if (minLen > s.length()) {  
            return "";  
        }  
    
    
        return s.substring(minLeft, minLeft + minLen);
        
        
    }
}
