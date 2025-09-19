import java.util.*;
import java.io.*;

class Solution {
    int answer, N, M, L;
    int[][] arr;
    boolean[] sel;
    Set<String> set;
    
    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        N = n;
        M = m;
        L = info.length;
        arr = info;
        sel = new boolean[L];
        set = new HashSet();
        dfs(0, 0, 0);
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    public void dfs(int i, int B, int A) {
        if(i >= L) {
            answer = Math.min(A, answer);
            return;
        }
        
        if(A > answer) return;
        
        //위의 선택은 달라도 점수가 같으면 볼 필요 없음.... 뭘 선택했느냐 보단.. 점수가 중요
        String key = i + " " + B + " " + A;
        if(set.contains(key)) return;
        set.add(key);
        
        //도둑 B가 훔칠 것 선택하기
        if(M > B + arr[i][1]) {
            dfs(i+1, B + arr[i][1], A);
        }
        //선택하지 않기
        if(N > A + arr[i][0]) {
            dfs(i+1, B, A + arr[i][0]);
        }
        return;
    }
    
}