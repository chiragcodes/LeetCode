class Solution {
    
    public int partitionDisjoint(int[] nums) {
        
        /*
        
        Good Post: TC = O(N), SC = O(N)
        
        https://leetcode.com/problems/partition-array-into-disjoint-intervals/discuss/1354396/Python-Build-                   LeftMaxSoFar-RightMinSoFar-Clean-and-Concise
        
        
        Another Approach: TC = O(N), SC = O(1)
        
        Suppose, the original left subarray is from 0 to paritionIdx. So, max value of that is localMax
        -> If it is a valid partition, then every value from partitionIdx + 1 till end should be >= localMax
        
        But if we find a value in the right part arr[i] which is smaller than localMax.
        -> Means the partition is not correct and we have to incorporate arr[i] to left partition.
           So, partitionIdx is set to i. And again check localMax value for the new left partition now.
        
        */
        
        
        int n = nums.length;
        
        int localMax = nums[0], globalMax = localMax;
        
        int partitionIdx = 0;
        
        for (int i = 0; i < n; i++) {
            
            
            if (localMax <= nums[i]) {   // Till now, left partition is valid
                
                globalMax = Math.max(globalMax, nums[i]);   // keep updating the maximum till this element
                
            } else {   // Curr value greater than left parition max, so left partition becomes invalid
                
                partitionIdx = i;  // incorporate this element in new left partition
                localMax = globalMax;  // update localMax as max of this new left partition
            }
            
        }

        return partitionIdx + 1;
        
    }
}
