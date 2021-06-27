class Solution {
    
    
    public List<Integer> countSmaller(int[] nums) {
        
        
        /*  Approach 1: Brute Force.
        
            Use for loops: T.C. = O(n^2)
            
               loop i: 0 to n-1
                  loop j: i+1 + n-1
                      check if a[j] < a[i] : count++;
        
            Gives TLE.
        */
        
        
        /*  Approach 2:
        
            Use Insertion Sort to sort the current visited elements.
            Use binary search to find index of that element to update count.
            
        */
        
        int n = nums.length;
        
        int arr[] = new int[n];
        List<Integer> list = new ArrayList<>();
        
        
        // Loop from n-1 to 0
        
        for (int i=n-1; i>=0; i--) {
            
            arr[i] = sortSearchHelper(nums[i], 0, list.size(), list);
            
            
        }
        
        // Store the counts in result array
        
        List<Integer> res = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            
            res.add(arr[i]);
            
        }
        
        return res;
        
        
    }
    
    
    
    // Helper function which will use 'Insertion Sort and Binary Search'
    
    public int sortSearchHelper (int val, int low, int high, List<Integer> list) {
        
        // Binary search to find our element val in the insertion sorted array
        
        int mid = low + (high - low)/2;
        
        // Here, if binary search ends, means current mid is the value.
        
        if (low >= high) {
            
            list.add(mid, val);
            return mid;
            
        }
        
        // Check if given val is present on left or right side of mid value.
        
        if (val <= list.get(mid)) {
            
            return sortSearchHelper (val, low, mid, list);
            
        } else {
            
            return sortSearchHelper (val, mid + 1, high, list);
            
        }
        
        
    }
    
    
    
}
