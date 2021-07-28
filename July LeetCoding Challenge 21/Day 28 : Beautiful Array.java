class Solution {
    
    public int[] beautifulArray(int n) {
        
        /*
        
        Good post : 
        https://leetcode.com/problems/beautiful-array/discuss/187669/Share-my-O(NlogN)-C%2B%2B-solution-with-proof-and-explanation
        https://leetcode.com/problems/beautiful-array/discuss/186679/Odd-%2B-Even-Pattern-O(N)
        
        */

        
        ArrayList<Integer>  ans = new ArrayList<>();
        
        ans.add(1);
        
        while (ans.size() < n) {
            
            ArrayList<Integer> temp = new ArrayList<>();
            
            for (int i : ans) {
                
                if (i * 2 - 1 <= n) {
                    
                    temp.add(i * 2 - 1);
                    
                }
                
            }
            
            for (int i : ans) {
                
                if (i * 2 <= n) {
                    
                    temp.add(i * 2);
                    
                }
                
            }
            
            ans = temp;
            
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
        
        
    }
}
