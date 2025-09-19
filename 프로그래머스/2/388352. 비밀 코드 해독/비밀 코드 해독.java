import java.io.*;
import java.util.*;

class Solution {
    int[] sel;
    int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        sel = new int[5];
        perm(1, 0, n, q, ans);
        return answer;
    }
    
    private void perm(int idx, int selIdx, int n, int[][] q, int[] ans) {
        if(selIdx == 5) {
            //q를 돌면서
            for(int i = 0; i < q.length; i++) {
                int cnt = 0;
                //다섯개 숫저 sel과 배교
                for(int j = 0 ; j < 5; j++) {
                    boolean check = false;
                    for(int z = 0; z < 5; z++) {
                        if(q[i][j] == sel[z]) check = true;
                    }
                    if(check) cnt ++;
                }
                if(cnt != ans[i]) return;
            }
            answer++;
            return;
        }
        
        for(int i = idx; i <= n; i++) {
            sel[selIdx] = i;
            perm(i+1, selIdx + 1, n, q, ans);
        }
    }
}