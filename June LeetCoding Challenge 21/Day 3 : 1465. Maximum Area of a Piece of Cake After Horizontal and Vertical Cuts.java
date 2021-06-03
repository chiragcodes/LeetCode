class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        /* Idea is to maximize the height and width for maximizing area of Rectange 
           We have to sort both the arrays.
           
           -> Find max diff between hor[i] - hor[i-1] for max width
           -> Find max diff between ver[i] - ver[i-1] for max height
           -> Multiply maxWidth * maxHeight => maxArea
        
           Example: hor = [2, 4, 7]  ver = [3, 5, 8] 
                    Consider corner case also:
                    i. Corners  => [0, 2, 4, 7, h]   [0, 3, 5, 8, w]
           
                    Sometimes, it may be possible that the corners (which itselfs are cuts)
                    also can have larger area:
                    
                    eg: [0, 12, 14, 17, h] 
                        => { 12-0 or h-17 } can be more than { 14-12 or 17-14 }
        */
        
        // Sort the arrays for finding max differences
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int m = horizontalCuts.length;
        int n = verticalCuts.length;

        // Calculate max diff for corner case : (arr[0] - 0), (total h/w - arr[n-1]) 
        
        long horMax = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        long verMax = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        
        // Compare corner case differences with alternate coordinates, update max.
        
        for (int i = 1; i < m; i++) {
            horMax = Math.max(horMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        for (int i = 1; i < n; i++) {
            verMax = Math.max(verMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        // Return answer module mod.
        
        double mod = 1000000007;
        return (int) ((horMax * verMax) % mod);
                
    }
}
