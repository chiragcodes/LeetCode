class MyCalendar {
    
    /*  Approach:
    
        We will use TreeMap here.

        Difference : 

        - HashMap does not maintain insertion order.   TreeMap maintains sorted asc order for insertion.
        - HashMap have O(1) lookup and insertion time. TreeMap have O(logN) lookup and insertion time.
    
    */
    
    // Declaring class object TreeMap
    
    TreeMap<Integer, Integer> map = new TreeMap<>();

    // Here, key will be start and value will be end.

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        
        // If already contains key as start, return false
        if (map.containsKey(start)) {
            return false;
        }
        
        /*  eg: TreeMap = (1,a)  (2,b)  (3,c)  (4,d) (5,e)  (6,f) 

            Higher Entry - Returns the minimum value key higher than given key, Else null
            higherEntry(3) = 4.  (out of 4,5,6  -  4 is the least key greater than 3)
            
            Lower Entry - Returns the maximum value key less than given key, Else null
            lowerEntry(3) = 2.  (out of 1,2  -  2 is the greatest key lower than 3)
        
        */
        
        var lowerInterval = map.lowerEntry(start);   // return type is obj. cannot be int.
        var higherInterval = map.higherEntry(start);
        
        /*
            Our case will work only will there is space for start - end interval as shown below.


            eg:  ...   lowerKey  ---  lowerValue   ... |    start  ---  end   | ...  higherKey   ---  higherValue  
                                                       |                      |
                     (lower start)    (lower end)      | (provided intervals) |    (higher start)     (higher end)


            So, if previous key's start and end are less than given start.  => previous end < start given
                if next     key's start and end are more than given end.    => next start   < end   given


 
        */
        
        
        if ( (lowerInterval  == null || start >= lowerInterval.getValue()) && 
             (higherInterval == null || end <= higherInterval.getKey()) ) {
            
            // If there is an interval present for start - end, return true. But also add this entry for other intervals.
            map.put(start, end);
            
            return true;
            
        }
        
        return false;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
