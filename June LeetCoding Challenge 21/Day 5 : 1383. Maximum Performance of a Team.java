class Solution {
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        /*  Approach:
        
            Create group of engineers (efficiency, speed). 
            => Sort this group array based on efficiency
            Use priority queue for storing slowest speed till the loop
            => It will be sorted automatically in queue with smallest value at first.
            If curr team size in queue passes k
            => Remove the slowest enginner q[0] and check values for new engineer (ith element)
            
        */
        
        
        // Store the efficiency and speeds of enginners as groups in 2D array
        
        int engineers[][] = new int[n][2];  // 0 -> efficiency  1 -> speed
        
        for (int i=0; i<n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }
        
        // Sort the array based on higher efficiency of engineer
        
        Arrays.sort(engineers, (a,b) -> b[0] - a[0]);  // default is a[0] - b[0]
        
        // Priority queue - slowest speed engineer will remain at front to be popped out.
        
        PriorityQueue<Integer> currentTeamPQ = new PriorityQueue<>((a,b) -> a - b);
        
        /* Loop through engineers by efficiency */
        
        long currentTeamSpeed = 0;
        long maxPerformance = Long.MIN_VALUE;
        
        for (int i=0; i<n; i++) {
            
            // If current team size exceeds given size k, remove the slowest engineer and try new one.
            if (currentTeamPQ.size() == k) {
                // remove entry of slowest engineer and deduct its speed from current team's speed
                currentTeamSpeed = currentTeamSpeed - currentTeamPQ.poll();
            }
            
            // Add the new engineer to team (Either as replacement if size == k or add as new one)
            currentTeamPQ.add(engineers[i][1]);           
            
            // Add new engineer's speed to current team speed
            currentTeamSpeed = currentTeamSpeed + engineers[i][1];
            
            /*  Check new changed performance by adding new engineer in team 
                
                Formula := (sum of speeds of engineers in team) * (min of efficiency of engineers in team);
                
                           Sum of speeds of engineers in team is currentTeamSpeed
                           Min of efficy of engineers in team is new added engineer's efficiency
                           // As efficiency is sorted from high -> low, current is <= before one's

                        := currentTeamSpeed * currentEmplEfficiency
            
            */
            
            long performanceWithNewEngineer = currentTeamSpeed * engineers[i][0];
            
            // Update result if performance improved by bringing current enginner in team
            maxPerformance = Math.max(maxPerformance, performanceWithNewEngineer);
            
        }
        
        return (int) (maxPerformance % (long) (Math.pow(10,9) + 7)
                     );
        
    }
}
