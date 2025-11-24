import java.util.*;

class Solution {
    
    String target;
    String[] words;
    boolean[] visited;
    int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        this.words = words;
        this.target = target;
        if(!Arrays.stream(words).anyMatch(s -> s.equals(target))) return 0;
        
        dfs(0, begin);
        
        
        return answer;
    }
    
    private void dfs(int cnt, String cur) {
        if(cur.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        if(cnt >= answer) return;
        
        for(int i = 0; i < words.length; i++) {
            
            if(visited[i]) continue;
            
            String str = words[i];
            
            int diff = 0;
            //단어 하나씩 보면서 1개 다른지 보기
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) != cur.charAt(j)) diff++;
                if(diff > 1) break;
            }
            
            if(diff == 1) {
                visited[i] = true;
                dfs(cnt+1, str);
                visited[i] = false;                
            }
        }
    }
}