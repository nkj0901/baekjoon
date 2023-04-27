import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int s = wires[i][0]-1;
            int e = wires[i][1]-1;  
            adjList[s].add(e);
            adjList[e].add(s);
        }
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < adjList[i].size(); j++){
                
                //0부터 시작
                queue.add(0);
                int cnt = 0;
                boolean[] visited = new boolean[n];
                while(!queue.isEmpty()){
                    int num = queue.poll();
                    
                    if(visited[num]) continue;
                    visited[num] = true;
                    cnt++;
                    
                    for(int a = 0; a < adjList[num].size(); a++){
                        //i,j 사이의 연결 선을 끊어버림
                        if(num == i && adjList[num].get(a) == adjList[i].get(j)|| num == adjList[i].get(j) && adjList[num].get(a) == i) continue;
                        if(visited[adjList[num].get(a)]) continue;
                        queue.add(adjList[num].get(a));
                    }
                }
                answer = Math.min(answer, Math.abs((n-cnt)-cnt));
            }            
        }
        
        return answer;
    }
}