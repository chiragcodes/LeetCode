class Solution {
    
    public int candy(int[] ratings) {
        
        
        /*  Approach :
        
            Initially give all the children 1 candy.
            
            Move from left to right -> 
            - if any right child has more rating than left, give it more candy then left child.
            
            Move from right to left ->
            - if any left child has more rating than right, give it more candy then right child.
        
            -> Now, in the 2nd traversal, it may be possible that left child was already having 
               more candy than right child's candy + 1. Then, no need to update.
        
        */
        
        
        int n = ratings.length;
        
        int candies[] = new int[n];
        Arrays.fill(candies, 1);    // give all children 1 candy
        
        // Give right child more candy than left if having higher rating
        
        for (int i = 1; i < n; i++) {
            
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
            
        }
        
        // Give left child more candy than right if having higher rating
        
        for (int i = n-2; i >= 0; i--) {
            
            // If already having more candy than right child, no need to update.
            
            if (ratings[i] > ratings[i+1] && (candies[i+1] + 1 > candies[i])) {
                candies[i] = candies[i+1] + 1;   
            }
            
        }
        
        // Count total numbers of candy required and return
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count = count + candies[i];    
        }
        
        return count;
        
    }
}
