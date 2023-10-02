import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        int N = times.length;
        Arrays.sort(times);
        
        long start = times[0];
        long end = (long)times[N-1]*(long)n;
        long mid;
        long sum;
        
        while(start <= end) {
            sum = 0;
            mid = (start+end)/2;
            
            for(int i = 0; i < N; i++){
                sum+=mid/times[i];
            }
            
            if(sum >= n) {
                end = mid-1;
                answer = Math.min(answer, mid);
            } else {
                start = mid+1;
            }
        }
        return answer;
    }
}