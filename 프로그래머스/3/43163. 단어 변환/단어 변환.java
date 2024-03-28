import java.util.*;

class Solution {
    int min;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        min = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        dfs(0, begin, 0, target, words);
        
        if(min == Integer.MAX_VALUE) answer = 0;
        else answer = min;
        return answer;
    }
    
    private void dfs(int idx, String now, int cnt, String target, String[] words) {
        
        if(cnt >= min) return;
        
        if(idx >= words.length) {  
            return;
        }
        
        if(now.equals(target)){
            min = Math.min(min, cnt);
            return;
        }
        
        int count;
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            count = 0;
            for(int j = 0; j < now.length(); j++) {
                if(now.charAt(j) != words[i].charAt(j)) count++;
            }
            if(count == 1) {
                visited[i] = true;
                dfs(i, words[i], cnt+1, target, words);
                visited[i] = false;
            }
        }       
    }
}