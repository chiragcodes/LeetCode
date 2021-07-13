class Solution {
    
    public int findPeakElement(int[] nums) {
        
        
        /* Good Note:
           https://leetcode.com/problems/find-peak-element/discuss/193152/Please-give-more-credits-to-this-type-of-question.
           
           https://leetcode.com/problems/find-peak-element/discuss/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search
           
        */
        
        int n = nums.length;
        
        if (n == 1) {
            return 0;   // only single element present and corners are -INF, so 0th index is peak
        }

        
        // For length >= 2, check the corner elements if they are peak
        
        if (nums[0] > nums[1]) {
            return 0;
        }
        
        if (nums[n-1] > nums[n-2]) {
            return n-1;
        }

        // Search the peak in the middle segment using Binary Search
        
        int start = 1, end = n-2;
        
        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            
            if ( nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1] ) {
                
                return mid;     // If mid is a peak, return it
                
            } else if ( nums[mid - 1] > nums[mid] ) {
                
                end = mid - 1;
                
            } else if ( nums[mid] < nums[mid + 1] ) {
                
                start = mid + 1;
                
            }
            
        }
        
        return -1;   // If no peak exists, then -1 will be returned.
        
    }
}
