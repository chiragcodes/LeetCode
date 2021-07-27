class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        
        // Good Post : https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
        
        /* Approach: Sort the array
                     Use 2 pointer technique to reach close to target sum 
        */
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int sum = nums[0] + nums[1] + nums[n-1];
        
        int closestSum = sum;
        
        for (int i = 0; i < n - 2; i++) {
            
            if (i == 0 || nums[i] != nums[i - 1]) {
                
                int low = i + 1, high = n - 1;
                
                while (low < high) {
                    
                    sum = nums[low] + nums[high] + nums[i];
                    
                    if (sum < target) {
                        
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        
                        low++;
                        
                    } else if (sum > target) {
                        
                        while (low < high && nums[high] == nums[high - 1]) {
                            
                            high--;
                            
                        }
                        
                        high--;
                        
                    } else {
                        
                        return sum;
                        
                    }
                    
                    // Update closest sum if needed
                    
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        
                        closestSum = sum;
                        
                    }
                    
                }
                
            }
            
        }
        
        
        return closestSum;
        
    }
}
