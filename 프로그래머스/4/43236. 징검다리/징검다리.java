import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int l = rocks.length;
        
        Arrays.sort(rocks);
        
        int[] dist = new int[l + 1];
        dist[0] = rocks[0];
        dist[l] = distance - rocks[l-1];
        for(int i = 1; i < l; i++) {
            dist[i] = rocks[i] - rocks[i-1];
        }
        
        int right = distance;
        int left = 0;
        
        while(left <= right) {
            int m = (left+right)/2;
            int mCnt = 0;
            int[] tmp = dist.clone();
            //최대 거리를 m이라고 했을 때 몇개의 돌다릴르 없애야 하는지
            for(int i = 0; i < l; i++) {
                if(tmp[i] < m) {
                    tmp[i] += tmp[i + 1];
                    tmp[i + 1] = tmp[i];
                    mCnt++;
                }
            }
            
            if(tmp[l] < m) mCnt++;
            
            // System.out.println("m : "  + m);
            // System.out.println("mCnt : "  + mCnt);
            // System.out.println(Arrays.toString(tmp));
            
            if(mCnt > n ) {
                right = m - 1; 
            } else {
                answer = m;
                left = m + 1;
            }
        
        }

        return answer;
    }
}