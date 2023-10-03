import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        //누구 이겼는지 표시
        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = 1;
        }
        
        //플로이드 워셜
        for(int k = 1; k <=n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    //k를 거쳐서 오는 길이 있다면 1 표시
                    if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                }
            }
        }
        
        //지거나 이긴 경우가 n-1개라면 순위를 확정할 수 있음
        int game;
        for(int i = 1; i <= n; i++) {
            game = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == 1 || graph[j][i] == 1) game++;
            }
            if(game == n-1) answer++;
        }             
        return answer;
    }
}