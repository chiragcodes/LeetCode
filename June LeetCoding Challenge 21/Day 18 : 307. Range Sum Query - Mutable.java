class NumArray {
    
    // Use Binary Index Tree Approach
    
    int data[] = null;
    long BIT[] = null;
    

    public NumArray(int[] nums) {
        
        int n = nums.length;
        
        data = new int[n];
        BIT = new long[n+1];  // to store index from 0 to n
        
        for (int i=0; i<n; i++) {
            update(i, nums[i]);  // call update for every index and its val.
        }
        
    }
    
    
    
    public void update(int index, int val) {
        
        long diff = val - data[index];  // take difference of prev value - current value
        
        data[index] = val;  // update the val for index.
        index++;
        
        // Loop till end of binary index tree length
        
        while (index < BIT.length) {
            
            BIT[index] = BIT[index] + diff;
            index = index + (index & -index);
            
        }
        
    }
    
    
    
    public int sumRange(int left, int right) {
        
        
        long sumRight = 0, sumLeft = 0;
        
        while (left > 0) {
            
            sumLeft = sumLeft + BIT[left];
            left = left - (left & -left);
            
        }
        
        right++;
        while (right > 0) {
        
            sumRight = sumRight + BIT[right];
            right = right - (right & -right);
            
        }

		return (int) (sumRight - sumLeft);
        
    }
    
    
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
