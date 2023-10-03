import java.util.*;

class Solution {
    
    class Node{
        int number, cnt;
        Node(int number, int cnt){
            this.number = number;
            this.cnt = cnt;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 1;
        
        List<Integer>[] list = new List[n+1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        dist[0] = 0;
        
        while(!queue.isEmpty()){
            Node num = queue.poll();
            int number = num.number;
            
            if(visited[number]) continue;
            visited[number] = true;
            dist[number] = num.cnt;
            
            for(int i = 0; i < list[number].size(); i++) {
                int cur = list[number].get(i);
                if(visited[cur]) continue;
                queue.add(new Node(cur, num.cnt+1));
            } 
        }
        
        Arrays.sort(dist);
        int max = dist[n];
        for(int i = n-1; i >= 0; i--){
            if(dist[i] == max) answer++;
            else break;
        }
        return answer;
    }
}