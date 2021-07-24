class Solution {
    
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        
        /* Similar to open lock approach
        
        Good Post : 
        https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
        
        */
        
        
        // If there are no ways to move as dictionary has no words, return empty path.
        
        if (wordList.size() == 0) {
            
            return new ArrayList<>();
            
        }
        
        
        
        List<List<String>> result = new ArrayList<>();   // stores final res list
        
        Map<String, HashSet<String>> graph = new HashMap<>();  // adj list of keys
        // Stores all neighbours of each word with 1 char diff
        
        Map<String, Integer> distance = new HashMap<>();  // distance betn begin and curr word
        
        HashSet<String> dict = new HashSet<>(wordList); // for searching purpose
        
        
        bfs (beginWord, endWord, dict, graph, distance);
        
        dfs(result, graph, distance, endWord, beginWord, new ArrayList<>(Arrays.asList(beginWord)));
     
        return result;
        
        
    }
    
    
    
    // Use BFS to build graph (adjacency list of each word), as well as 
    // calculating distance from beginWord to each node in the graph (should store minimum distance)
    
    public void bfs (String beginWord, String endWord, HashSet<String> dict, Map<String, HashSet<String>> graph,
                     Map<String, Integer> distance) {
        
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        
        while (!queue.isEmpty()) {
            
            boolean reachEnd = false;
            
            int size = queue.size();  // Loop for every level of length size
            
            for (int i = 0; i < size; i++) {
                
                String currWord = queue.poll();
                
                // Check all 26 transformation for currWord. IF newWord exists in dictionary, add to adj list.
                
                for (int j = 0; j < currWord.length(); j++) {
                    
                    char nextCombination[] = currWord.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        
                        nextCombination[j] = c;
                        
                        String newWord = new String(nextCombination);
                        
                        if (dict.contains(newWord)) {
                            
                            graph.putIfAbsent(currWord, new HashSet<>());
                            graph.get(currWord).add(newWord);
                            
                        }
                        
                    }
                    
                }
                
                
                // Traverse all neighbours of currWord, update distance map and queue for next level.
                
                for (String neighbour : graph.get(currWord)) {
                    
                    if (!distance.containsKey(neighbour)) {
                        
                        distance.put(neighbour, distance.get(currWord) + 1);
                        
                        if (neighbour.equals(endWord)) {
                            reachEnd = true;
                        } else {
                            queue.offer(neighbour);
                        }
                        
                    }
                    
                }
                
                
                if (reachEnd) {
                    break;
                }
                
                
            }
            
        }
        
    }
    
    
    
    // Use DFS to traverse and record path from beginWord to endWord with shortest path. 
    // We can use distance map to control every next word
    
    public void dfs (List<List<String>> result, Map<String, HashSet<String>> graph, Map<String, Integer> distance,
                     String endWord, String currWord, List<String> tempList) {
        
        
        if (currWord.equals(endWord)) {
            
            result.add(new ArrayList<>(tempList));
            return;
            
        }
        
        for (String nextWord : graph.get(currWord)) {
            
            // If next node is on same minimum path distance, then only we will include it for traverse
            
            if (distance.get(nextWord) == distance.get(currWord) + 1) {
                
                tempList.add(nextWord);
                dfs(result, graph, distance, endWord, nextWord, tempList);
                tempList.remove(tempList.size() - 1);
                
            }
            
        }
        
        
    }
    
    
    
    
}
