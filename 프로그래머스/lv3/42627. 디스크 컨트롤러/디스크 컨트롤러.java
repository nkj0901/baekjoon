import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int N = jobs.length;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }

        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int idx = 1;
        int end = jobs[0][0];
        pq.offer(jobs[0]);       
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            end+=cur[1];
            answer+=end-cur[0];
            
            while(idx < N && end >= jobs[idx][0]){
                pq.offer(jobs[idx++]);
            }
            
            //하드디스크가 작업을 수행하고 있지 않다면
            if(idx < N && pq.isEmpty()){
                end =jobs[idx][0];
                pq.offer(jobs[idx++]);
            }
        }
        return answer/N;
    }
}