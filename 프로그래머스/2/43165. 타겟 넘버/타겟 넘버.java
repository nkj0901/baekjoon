import java.io.*;
import java.util.*;

class Solution {
    boolean[] sel;
    int[] numbers;
    int l, target, answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        l = numbers.length;
        sel = new boolean[l];
        this.numbers = numbers;
        this.target = target;
        
        dfs(0);
        return answer;
    }
    
    private void dfs(int idx) {
        if(idx == l) {
            // System.out.println(Arrays.toString(sel));
            int sum = 0;
            for(int i = 0; i < l; i++) {
                if(sel[i]) sum+=numbers[i];
                else sum-=numbers[i];
            }
            if(sum == target) answer++;
            return;
        }
        
        sel[idx] = true;
        dfs(idx+1);
        sel[idx] = false;
        dfs(idx+1);
    }
}