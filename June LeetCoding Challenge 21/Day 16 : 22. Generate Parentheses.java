class Solution {
    
    
    
    public List<String> generateParenthesis(int n) {
        
        List <String> res = new ArrayList <String> ();
        
        int pairLength = 2 * n;   // no. of pairs = n. So, string length with pairs '(' and ')' is 2n. 
        
        recHelper ("", 0, 0, pairLength, res);  // Call recursive backtracking to solve this.
        
        return res;
        
    }
    
    
    
    /* Helper function to create and check valid parenthesis */
    
    public void recHelper (String s, int openBracket, int closeBracket, int pairLength, List <String> res) {
        
        System.out.println(s);
        // Base or Return Condition
        
        if (s.length() == pairLength) {
            System.out.println("Added : "+s);
            
            res.add(s);   // If str length becomes equal to pair length, add to result and return.
            return;       // Even, if we don't write return, below conditions will not satisfy and returns.
        
        }
        
        // Every time, try to add opening brackets if curr opening brackets < required opening brackets
        
        if (openBracket < pairLength/2) {
            
            recHelper (s + '(', openBracket + 1, closeBracket, pairLength, res);
            
        }
        
        // Else If opening brackets are full, close them with closing brackets till < opening brackets
        
        if (closeBracket < openBracket) {
            
            recHelper (s + ')', openBracket, closeBracket + 1, pairLength, res);
            
        }
        
    }
    
    
    
    /*  Recursion Tracking
    
        Steps: 
        
        - Add opening brackets, till it is equal to n
        - If closing brackets are less than opening brackets, add closing brackets.
    
    
    n = 1;
        
        (
        ()
        
        Added : ()
        
        
        
    n = 2;
        
        (
        ((
        (()
        (())
        
        Added : (())
        
        ()
        ()(
        ()()
        
        Added : ()()

        
        
    n = 3;
        
        (
        ((
        (((
        ((()
        ((())
        ((()))
        
        Added : ((()))
        
        (()
        (()(
        (()()
        (()())
        
        Added : (()())
        
        (())
        (())(
        (())()
        
        Added : (())()
        
        ()
        ()(
        ()((
        ()(()
        ()(())
        
        Added : ()(())
        
        ()()
        ()()(
        ()()()
        
        Added : ()()()
        
    
    
    */
    
    
    
}
