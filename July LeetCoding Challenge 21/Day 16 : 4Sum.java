class Solution {
    
    
    // Good post : https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA
        
    // TC = SC = O(N^2)
    
    
    
    /*  Create new class Pair to store pairs of numbers after sorting array  */
     
    private class Pair {
        
        int p1;    
        int p2;
        
        public Pair (int p1, int p2) {
            
            this.p1 = p1;
            this.p2 = p2;
            
        }
        
        // Validate if given two pairs (all 4 indexes a,b,c,d should be distinct)
        
        // And passed by reference pair is next pair than passed by object pair (current pair)
        
        public boolean isValidNext (Pair p) {
            
            if (this.p1 >= p.p1 || this.p1 >= p.p2 || this.p2 >= p.p1 || this.p2 >= p.p2) {
                return false;
            }
            return true;
        }
        
        // Check if pairs are not duplicate. eg:  (1, 2) (1,2)  =>  1,2,1,2  should not be counted twice
        
        public boolean isSame (Pair p, int arr[]) {
            
            return ( arr[this.p1] == arr[p.p1] && arr[this.p2] == arr[p.p2] );
            
        }
        
    }
    
    
                    /* Implementation method */
    
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        
        int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 4) {
            
            return res;   // no quadruplets possible in the list if less than 4 elements
            
        }
        
        
        Arrays.sort(nums);
        
        
        // Store all two pairs sum in the Map
        
        HashMap <Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        

        for (int i = 0; i < n; i++) {
            
            for (int j = i + 1; j < n; j++) {
                
                int sum = nums[i] + nums[j];
                
                Pair p = new Pair(i, j);
                
                if (!map.containsKey(sum)) {
                    
                    map.put(sum, new ArrayList<Pair>());
                    
                }
                
                List<Pair> pairs = map.get(sum);
                pairs.add(p);
                
            }
            
        }
        

        // For every pairSum 'm' in map, identify the quadruplets whose sum is target
        
        for (int m : map.keySet()) {
            
            int reqPairSum = target - m;
            
            // If the required pairSum is present in map, then the target can be achieved
            
            if (map.containsKey(reqPairSum)) {
                
                List<Pair> pair1 = map.get(m);
                List<Pair> pair2 = map.get(reqPairSum); 
                
                Pair prev1 = null;
                
                for (Pair p1 : pair1) {
                    
                    // Check to avoid duplicates
                    
                    if (prev1 != null) {
                        
                        if (prev1.isSame(p1, nums)) {
                            continue;
                        }
                        
                    }
                    
                    Pair prev2 = null;
                    
                    for (Pair p2 : pair2) {
                        
                        // Check to avoid duplicates
                        
                        if (prev2 != null) {
                            
                            if (prev2.isSame(p2, nums)) {
                                continue;
                            }
                            
                        }
                        
                        // Have the pairs indexes in order
                        
                        if (p1.isValidNext(p2)) {
                            
                            prev1 = p1;
                            prev2 = p2;
                            
                            List<Integer> temp = new ArrayList<Integer>();
                            
                            temp.add(nums[p1.p1]);
                            temp.add(nums[p1.p2]);
                            temp.add(nums[p2.p1]);
                            temp.add(nums[p2.p2]);
                            
                            res.add(temp);
                            
                        }
                        
                    }
                    
                }
                
                
            }
            
        }
 
    
    return res;
        
          
    }
}
