class Solution {
    
    private int[] nums;

    
    public Solution(int[] nums) {
        
        // Assign the given nums array to the class variable to initialize
        this.nums = nums;
        
    }
        
    
    public int[] reset() {
        
        // Original configuration still remains in nums. For shuffling, we are returning copied array.
        return nums;
        
    }
    
    
    public int[] shuffle() {
        
        // Store shuffled values in copied array arr, and return it.
        
        int[] arr = new int[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            
            int temp = (int) (Math.random() * (i + 1));
            arr[i] = arr[temp];
            arr[temp] = nums[i];
            
        }

        return arr;
        
    }
    
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
