class Solution {
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
                
        /*  Approach:
        
            We will create a priority queue which will store the the fuels (arr[i][1]) in descending order
            The stations with more fuel will be ahead (reverse sorting) so that max fuel can be taken when needed
            
        */
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int countStops = 0;
        int currStation = 0;
        int currFuel = startFuel;

        // Loop till current fuel is less than required fuel. Else return as currFuel is sufficient to reach target.
        
        while (currFuel < target) {
            
            // Traverse next station till current station are not completed.
            // and current fuel is more than sufficient to reach current station
            
            while (currStation < stations.length && currFuel >= stations[currStation][0])  {
                pq.add(stations[currStation][1]);
                currStation++;
            }
            
            // If at any time no element present, means till we reach nearest fuel pump, car already exhausted.
            if (pq.size() <= 0) {
                return -1;  // not possible.
            }
            
            // When above while loop breaks, then update current fuel to add more Max(fuels seen till now)
            currFuel = currFuel + pq.remove();
            countStops++;
            
        }
        
        return countStops;   
        
    }
}
