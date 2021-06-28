class Solution {
    
    public String removeDuplicates(String s) {
        
        
        Stack <Character> stack = new Stack();
        
        StringBuilder res = new StringBuilder();
        
        // Check for every char in given string.
        
        for (char ch : s.toCharArray()) {
            
            // If curr char is same as top of stack, remove it. Else add it.
            
            if (!stack.isEmpty() && ch == stack.peek()) {
                
                stack.pop();  // remove top of stack as same as curr. Both removed.
                
            } else {
                
                stack.push(ch);   // add curr char to top of stack as different.
                
            }
            
        }
        
        
        // The elements remaining in the stack are now not having adjacent duplicates
        
        while (!stack.isEmpty()) {
            
            res.append(stack.pop());
            
        }
    
        
        // Return reverse of string as stack was storing elements from right to left.
        
        return res.reverse().toString();
        
        
    }
}
