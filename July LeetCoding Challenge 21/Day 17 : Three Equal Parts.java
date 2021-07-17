class Solution {
    
    public int[] threeEqualParts(int[] arr) {
        
        // Good Post : https://leetcode.com/problems/three-equal-parts/discuss/183922/C%2B%2B-O(n)-time-O(1)-space-12-ms-with-explanation-and-comments
        
        int cntOne = 0;
        int res[] = new int[2];
        
        int n = arr.length;
        
        // Count no of 1s in array
        
        for (int i=0; i<n; i++) {
            
            if (arr[i] == 1) {
                cntOne++;
            } 
            
        }
        
        // If no of 1s is zero, then all three parts can have decimal value 0. => 0, 0 0, 0 ...
        
        if (cntOne == 0) {
            
            return new int[] {0, 2};   // i = 0, j = 2 as (i + 1 < j)
            
        }
        
        if (cntOne % 3 != 0) {
            
            return new int[] {-1, -1};   // No result possible as partition in 3 equal no 1s not possible
                
        }
        
        // Now, partition can exist, so check if partition possible
        
        int thirdPartStartingIndex = 0;
        int currCntOne = 0;
        
        // Traverse from end and try to do 3rd partion when we reach 1/3rd of total 1s in array
        
        for (int i=n-1; i>=0; i--) {
            
            if (arr[i] == 1) {
                
                currCntOne++;
                
                /* If we reach index where curr 1s = 1/3rd of total 1s. So, its the 3rd partition.
                
                   1  0  0  1  0  0  1  0
                   ----  -------  -------
                     2      2        2   
                
                */
                if (currCntOne == cntOne / 3) {
                    
                    thirdPartStartingIndex = i;
                    break;
                    
                }
                                
            }
            
        }
        
        int firstPartEndIndex = findNextEndIndexAndCompare(arr, 0, thirdPartStartingIndex);
        
        if (firstPartEndIndex < 0) {
            
            return new int[] {-1, -1};   // No result possible
            
        }
        
        int secondPartEndIndex = findNextEndIndexAndCompare(arr, firstPartEndIndex + 1, thirdPartStartingIndex);
        
        if (secondPartEndIndex < 0) {
            
            return new int[] {-1, -1};   // No result possible
            
        }
        
        
        // Finally return the partions index
        
        return new int[] {firstPartEndIndex, secondPartEndIndex + 1};
        
        
    }
    
    
    // Helper function to find partition from end
    
    private int findNextEndIndexAndCompare (int arr[], int low, int high) {
        
        // Try to reach to the 1st one by ignoring 0s
        
        while (arr[low] == 0) {
            
            low++;
            
        }
        
        // Loop till high reaches end of array
        
        while (high < arr.length) {
            
            // If at any time, traversing 1st and 2nd partition are different, return -1.
            
            if (arr[low] != arr[high]) {
                
                return -1;
                
            }
            
            low++;   // It traverse the 1st partition
            high++;  // It traverse the 2nd partition
            
        }
        
        // If while loop completed means high reaches end of array and partitions were same.
        
        return low - 1;
        
    }

    
}
