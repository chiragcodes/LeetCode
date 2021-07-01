class Solution {
    
    public List<Integer> grayCode(int n) {
        
        
        /*  Its like Tower of Hanoi, if able to solve fo 2, try to make patterns for 3 */
        
        /*  eg:
            
            For n = 0  =>     0
            For n = 1  =>     0    1
            For n = 2  =>    00   01   11   10
            For n = 3  =>   000  001  011  010  110  111  101  100
            For n = 4  =>  0000 0001 0011 0010 0110 0111 0101 0100 1100 1101 1111 1110 1010 1011 1001 1000 
            
            
            Pattern:
            
            If for n the elements are          a  b  c  d
            for n+1, the elements will be     0a 0b 0c 0d 1d 1c 1b 1a
            
            By doing this for n+1, we know that the 1st half will have diff of 1 bit as per n already done.
            Also, we start the same pattern in reverse order for 2nd half as its symetrical to 1st half.
            
            So, for n: elements will be guranteed to have 1 bit difference and 2 * (size for n-1) 
        
        */
        
        
        List<Integer> res = new ArrayList<Integer>();
        
        res.add(0);  // For n = 0, base case : 0
        
        
        for (int i = 1; i <= n; i++) {
            
            // Everytime, we already have the 1st half.
            // We need to add 1 ahead of reverse list of 1st half and store it.
            
            int m = res.size();
            
            // eg: for 101 we need 1000 to make it 1101. 
            // So, we need to shift 1, 3 (4-1) times to make it 1000
            
            int base = 1 << (i-1);  
            
            // Loop for all m elements and add them again by prefixing with 1.
            
            for (int j = m-1; j >= 0; j--) {
                
                res.add(base + res.get(j));
                
            }
            
        }
        
        return res;
        
    }
}
