class NumArray {

    
    private int[] prefixSum;
    
    
    public NumArray(int[] nums) {
        
        // During initialization here, calculate the prefix sum for once.
        
        int n = nums.length;
        
        prefixSum = new int[n];
        
        prefixSum[0] = nums[0];
            
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
        
    }
    
    
    // Return the difference between prefix sum of left and right
    
    public int sumRange(int left, int right) {
        
        int i = left, j = right;
        
        return i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
        
    }
    
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
