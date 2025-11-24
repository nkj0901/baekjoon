import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
       
        Queue<Integer> q = new LinkedList();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                        
                if(computers[i][j] == 1 && !visited[j]) q.add(j);
                else continue;               
                answer++;
                
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    
                    if(visited[cur]) continue;
                    visited[cur] = true;
                    
                    for(int z = 0; z < n; z++) {
                        if(computers[cur][z] == 1) q.add(z);
                    }

                }
                
            }
        }

        return answer;
    }
}