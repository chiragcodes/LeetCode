class Solution {
    
    public int minSetSize(int[] arr) {

        int n = arr.length;
        int sum = 0;
        
        int count[] = new int[100001];
        
        for (int i=0; i<n; i++) {
            
            count[arr[i]]++;
        
        }
        
        Arrays.sort(count);
        
        int j = 0;
        
        for (j = count.length - 1; j>=0; j--) {
            
            sum = sum + count[j];
            
            if (sum >= n/2) {
                break;
            }
            
        }
        
        return count.length - j;
        
    }
}
