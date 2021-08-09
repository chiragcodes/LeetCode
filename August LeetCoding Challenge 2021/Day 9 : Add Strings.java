class Solution {
    
    public String addStrings(String num1, String num2) {
        
        
        int m = num1.length(), n = num2.length();
        int carry = 0;
        
        int i = m - 1, j = n - 1;
        
        StringBuilder sb = new StringBuilder();  // using stringbuilder as appending take more time in string
        
        // Do until any of the numbers has digits remaining
        
        while (i >= 0 || j >= 0) {
        
            int s1 = 0, s2 = 0;
            
            if (i >= 0) {
                
                s1 = num1.charAt(i) - '0';
                
            }
            
            if (j >= 0) {
                
                s2 = num2.charAt(j) - '0';
                
            }
            
            int sum = s1 + s2 + carry;
            carry = sum / 10;
            
            sb.append(sum % 10);
            
            i--;
            j--;
            
        }
        
        if (carry != 0) {
            
            sb.append(carry);
        
        }
        
        return sb.reverse().toString();
        
        
    }
    
}
