/*

    Good Post:
    
    https://leetcode.com/problems/map-sum-pairs/discuss/107515/Simple-Java-HashMap-Solution-O(1)-sum-and-O(len(key))-insert
    
    https://leetcode.com/problems/map-sum-pairs/discuss/246447/Java-Solution-faster-than-100.00-submissions-using-Trie-and-HashMap
    
    https://leetcode.com/problems/map-sum-pairs/discuss/107553/Java-Map-solution!

*/

class MapSum {

    /** Initialize your data structure here. */
    
    Map <String, Integer> map = new HashMap<>();
    
    
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        
        map.put(key, val);
        
    }
    
    
    public int sum(String prefix) {
        
        
        int sum = 0;
        
            // For every key string in map, count total sum of keys starting with prefix
        
            for (String str : map.keySet()) {
            
                if (str.startsWith(prefix)) {
                
                  sum = sum + (map.get(str));
                
                 }
            
            }
        
        return sum;
        
    }
    
    
    
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
