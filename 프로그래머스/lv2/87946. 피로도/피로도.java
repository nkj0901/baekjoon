import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        return permutation(k, dungeons);
    }
    
    
    static int permutation(int k, int[][] dungeons){
        int ans = 0;
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                ans = Math.max(ans, permutation(k-dungeons[i][1], dungeons));
                visited[i] = false;
            } 

        }
        return Math.max(ans, adventure(visited));
    }
    
    static int adventure(boolean[] visited) {
        int cnt = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == true) cnt++;
        }
        return cnt;
    }
}


