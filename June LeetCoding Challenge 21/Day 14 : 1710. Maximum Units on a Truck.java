class Solution {
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        /*  Approach 1 : Greedy Approach. Will pick up the boxes type having max units to maximize final sum  */
        
        
        // Sort the array based on max (descending (by default is asc)) units available in box Types
        
        Arrays.sort( boxTypes, (a, b) -> (b[1] - a[1]) );  // arr[1] denotes the no. of units per box.
        
        // Check for all boxes considering max units till truck size is fully loaded.
        
        int maxUnits = 0;
        
        for (int i=0; i<boxTypes.length; i++) {
            
            // If at any time, trucksize is becoming less than current no of boxes for box type i.
            if (truckSize < boxTypes[i][0]) {
                return maxUnits + truckSize * boxTypes[i][1];  // return no. of units equal to remaining truck size
            }
            
            // Otherwise, add all the units available for box type i and reduce from truckSize
            
            maxUnits = maxUnits + boxTypes[i][0] * boxTypes[i][1];   // no. of boxes * units per box
            truckSize = truckSize - boxTypes[i][0];
        }
        
        
        return maxUnits;   // Time Comp : O(nlogn)  // sorting is bottleneck here for nlogn.
        
        
        
        
        
        /*   Approach 2 : Using extra array as boxes range is 0-1000.  */
        
        
        /*
        
        // Below is an array for the units per box. arr[3] = 2  will mean that there are 2 boxes which have 3 units per box. 
        
        int[] arr = new int[1001];   // values can be from 0 - 1000, so size is 1001
        
        int maxUnitBox=0;
        
        for (int i=0; i<boxTypes.lengthl i++) {
        
            // Here, we store the no. of boxes as a value for units present.
            // eg: arr [ units ] = arr [ units ] + (no. of boxes with that unit)
            
            arr[boxTypes[1]] = arr[boxTypes[1]] + boxTypes[0];
        
            // Also, simultaneously store the max unit occured till now.
            
            maxUnitBox = boxTypes[1] > maxUnitBox ? boxTypes[1] : maxUnitBox;
            
        }
        
        int maxUnits = 0;
        
        // Now, we know the max units per box which can occur. So, all the input array having units per box will be less than max.
        // So, we run a loop from max to 0 in this order, and add the no. of boxes with that units in truck till truck is full.
        
        for (int i = maxUnitBox; i>=0; i--) {
        
            // Default value of all elements is 0. So, if not 0, that means it is an input in actual array.
            
            if (arr[i] != 0) {
                
                if (truckSize < arr[i]) {
                    return maxUnits + truckSize * i;   // return remaining boxes space in truck * units per box.
                }
                
                // Otherwise, add all the units available i and reduce from truckSize
            
                maxUnits = maxUnits + arr[i] * i;   // no. of boxes for that unit * units per box
                truckSize = truckSize - arr[i];
            
            }
        
        }
        
       return maxUnits;     // Time Comp : O(n)  Space Comp: O(1000) or O(1) constant.
        
        */
        
        
    }
}
