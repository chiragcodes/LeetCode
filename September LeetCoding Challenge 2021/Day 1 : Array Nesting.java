class Solution {
    
    public int arrayNesting (int[] nums) {
        
        int n = nums.length;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            
            int index = i, count = 0;
            
            while (nums[index] < n && nums[index] != i) {
                
                count++;
                nums[index] = nums[index] + n;
                index = nums[index] - n;
                
            }
            
            count++;
            
            if (count > max) {
                max = count;
            }
            
            if (max >= (n + 1) / 2) {
                return max;
            }
                        
        }
        
        return max;

    }
}
