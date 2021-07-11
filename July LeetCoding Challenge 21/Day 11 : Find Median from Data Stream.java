class MedianFinder {

    /** initialize your data structure here. */
    
    /*
    
    Good Discussion to refer:
    https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
    
    */
    
    private PriorityQueue <Integer> leftHalf = new PriorityQueue<> (Collections.reverseOrder());
    
    private PriorityQueue <Integer> rightHalf = new PriorityQueue<>();
    
    private boolean isEven = true;
    

    
    public MedianFinder() {
        
    }
    
    
    public void addNum(int num) {
        
        // If no of elements are even, then offer or add the new number to rightHalf, else add to leftHalf
        
        if (isEven) {
            
            rightHalf.offer(num);
            leftHalf.offer(rightHalf.poll());
            
        } else {
            
            leftHalf.offer(num);
            rightHalf.offer(leftHalf.poll());
            
        }
        
        isEven = !isEven;  // toggle even to odd or odd to even as new no. is added
        
    }
    
    public double findMedian() {
        
        // If even no of elements, take median as mean of two medians, else if odd, then directly median
        
        if (isEven) {
            
            return ( leftHalf.peek() + rightHalf.peek() ) / 2.0;
            
        } else {
            
            return leftHalf.peek();
            
        }
        
    }
    
    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
