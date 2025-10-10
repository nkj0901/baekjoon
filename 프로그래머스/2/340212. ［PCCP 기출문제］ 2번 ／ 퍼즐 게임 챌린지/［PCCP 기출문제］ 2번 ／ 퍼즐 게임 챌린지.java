import java.io.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        //이분탐색으로 최소레벨 탐색하기
        int l = 1;
        int r = 100000;
        
        while(l <= r) {
            int m = (l + r)/2;
            long time = 0;
            
            // System.out.println(m);
            for(int i = 0; i < diffs.length; i++) {
                
                //레벨보다 난이도가 더 높으면 (time_cur + time_prev) * level - diffs[i] + time_cur
                if(diffs[i] > m && i != 0) {
                    time += (times[i] + times[i - 1]) * (diffs[i] - m) + times[i];
                }
                
                else time += times[i];
            }
            // System.out.println(time);
            //시간이 너무 적게 걸려 
            if(time <= limit) {
                r = m - 1;
            } else l = m + 1;            
        }
        
        return r + 1;
    }
}