class Solution {
    
    public boolean canReorderDoubled(int[] arr) {
        
        /*  We want all even index = 2 * (prev odd index)
        
            i.e.  arr[1] = 2 * arr[0]
                  arr[3] = 2 * arr[2]
                  arr[5] = 2 * arr[4]
                  arr[7] = 2 * arr[6] ...
                  
                  So, even term should be double of prev odd term in the entire array
                  
                  eg:  arr = [  a  2a  b  2b  c  2c  -d  -2d  e  2e  -f  -2f  ...  ]
        
        
        */
        
        
        // Store counts of occurence of every element in map
        // Here, we are using TreeMap as we want lowest element to come first as x/2 will not be valid for it
        
        
        Map <Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            
            map.put ( arr[i], map.getOrDefault(arr[i], 0) + 1 );
            
        }
        
        // For every distinct (key) element x in array, check if value 2*x is present or not
        
        for (int num : map.keySet()) {
            
            if (map.get(num) == 0) {
                
                continue;
                
            }
            
            int required = num < 0 ? num / 2 : num * 2;
            
            if ( num < 0  &&  num % 2 != 0  ||  map.get(num) > map.getOrDefault(required, 0) ) {
                
                return false;
                
            }
            
            map.put (required, map.get(required) - map.get(num) );
            
        }
        
        return true;
        
        
    }
}
