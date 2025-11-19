import java.io.*;
import java.util.*;

class Solution {    
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.numbers = numbers;
        this.target = target;
        answer = dfs(0, 0);
        return answer;
    }
    
    private int dfs(int idx, int sum) {
        if(idx == numbers.length) {
            if(sum == target) return 1;
            else return 0;
        }
        
        return dfs(idx + 1, sum + numbers[idx]) + dfs(idx + 1, sum - numbers[idx]);
    };
}