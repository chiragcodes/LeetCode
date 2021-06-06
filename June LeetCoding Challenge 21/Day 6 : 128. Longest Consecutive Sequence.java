class Solution {
    public int longestConsecutive(int[] nums) {
        
        /*  Approach
        
            1. Create a map and set the values of numbers as false which cannot be starting point of sequence:
               eg: If I have {3, 4, 5, 8, 9} then, 
                              3 and 8 can be starting points for sequence 3-4-5 and 8-9
                              4, 5 and 9 cannot be starting points as there are numbers 3 and 8 which can start before.

            2. For the numbers which can be starting points, check the max increasing count for them.
               eg: If I have {3, 4, 5, 8, 9} then, 
                              3 will have count (3-4-5) => 3
                              8 will have count (8-9)   => 2
                   So, max increasing count will be max(3,2) = 3.
        
        */
        
        /* Basically, it a number is not a starting point i.e. there is number one less than it, do nothing.
           If a number is a starting point, check the max count for sequence possible from that number. */
        
        // Add all numbers in the set : So that retreival of num -1 / num + 1 can be done in O(1) time.
        
        Set<Integer> numsSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            numsSet.add(nums[i]);
        }
        
        // Check max count available for each starting point element
        
        int maxSeq = 0;
        
        for (int i=0; i<nums.length; i++) {
            
            // IF current number is a starting point, i.e. set map does not contain its prev. number
            if (!numsSet.contains(nums[i]-1)) {
                
                int count = 1;
                
                // Run the loop till consecutive no's are present from curr. to curr. + count
                   // eg: nums[i] = 3. And (3+1) 4 and (3+2) 5, till (3+count) are also present
                while (numsSet.contains(nums[i] + count)) {
                    count++;
                }
                
                maxSeq = Math.max(maxSeq, count);  // check max seq. possible for all starting points numner.
                
            }
            
            
        }
        
        return maxSeq;
        
    }
}
