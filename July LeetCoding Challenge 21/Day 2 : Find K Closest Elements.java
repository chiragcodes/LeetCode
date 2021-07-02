class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        /*  Approach:  Array is sorted, so use 2 pointer technique to search nearest range
        
            It will take O(n-k) :- 
            
            We are checking array from (0 to low) and (high to n-1) where low to high is range k.
            
            So, we are checking n-k elements.
        
            
        */
        
        int n = arr.length;
        
        int low = 0, high = n-1;
        
        // Check diff of low and high with x, and minimize the range till reaches size k to return it.
           // Range size required is : k. Total size from high to low is : high - low + 1
        
        while (high - low + 1 > k) {
            
            // Decrease the range by removing the far element from x  i.e. moving its pointer
            
            if ( Math.abs( arr[low] - x )  > Math.abs( arr[high] - x )  ) {
                
                low ++;
                
            } else {
                
                high--;
                
            }
            
        }
        
        
        // Store that range in result array and return
        
        List <Integer> res = new ArrayList<>();
        
        for (int i = low; i <= high; i++) {
            
            res.add(arr[i]);
            
        }
        
        return res;
        
    }
}
