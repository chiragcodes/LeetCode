class Solution {
    
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        /*  Approach:

            i.  Single element subarray.
                - Here, A[i] is the only element. So it should be, left <= A[i] <= right.

            ii. Part of any subarray
                - There can be other element to be in between left and right.
                - But, atleast A[i] should be <= right, to be part of any subarray
            

            Three Cases for current element:
            
            1. A[i] < left

               - Single element subarray - No, as not between left/right. => Count = 0.

               - Part of subarray        - Yes, as A[i] <= right => Count = i - start.
            
            2. left <= A[i] <= right 
            
               - Single element subarray - Yes, as between left/right. => Count = 1.

               - Part of subarray        - Yes, as A[i] <= right => Count = i - start.

            3. A[i] > right

               - Single element subarray - No, as not between left/right. => Count = 0.

               - Part of subarray        - No, as A[i] > right   => Count = 0, start = i + 1
        
        
        */
         
        
        int start = 0, n = nums.length, count = 0;
        int subArrLenTillNow = 0;
        
        
        for (int i = 0; i < n; i++) {
            
            
            if (nums[i] < left) {
                
                count = count + subArrLenTillNow;  // Not single element subarray, Part of subarray
                
            } else if (nums[i] >= left && nums[i] <= right) {
                
                subArrLenTillNow = i - start + 1;
                count = count + subArrLenTillNow;   // Single element subarray, Part of subarray
                
            } else {
             
                start = i + 1;   // Not single element subarray, Not part of subarray
                subArrLenTillNow = 0;
                
            }
            
            
        }
        
        return count;
        
    }
}
