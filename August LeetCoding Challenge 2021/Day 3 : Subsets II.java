class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        recHelper (result, new ArrayList<>(), nums, 0);
        
        return result;
        
        
    }
    
    // Helper function
    
    public void recHelper (List<List<Integer>> res, List<Integer> list, int nums[], int pos) {
        
        res.add(new ArrayList<>(list));
        
        for (int i = pos; i < nums.length; i++) {
            
            if (i > pos && nums[i] == nums[i - 1]) {
                
                continue;
                
            }
            
            list.add(nums[i]);
            
            recHelper (res, list, nums, i + 1);
            list.remove(list.size() - 1);
            
        }
        
    }
    
    
        
}
