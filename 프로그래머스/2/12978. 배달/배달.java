import java.util.*;
import java.io.*;

class Solution {
    
    class Node implements Comparable<Node>{
        int v;
        int w;
        
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o1) {
            return this.w - o1.w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
    
        List<Node>[] list = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int s = road[i][0];
            int e = road[i][1];
            int w = road[i][2];
            
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }
        
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, 500000);
        dist[1] = 0;
        // visited[1] = true;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            
            if(visited[n.v]) continue;
            visited[n.v] = true;
            
            for(int i = 0; i < list[n.v].size(); i++) {
                Node next = list[n.v].get(i);
                // if(visited[next.v]) continue;
                
                if(next.w + dist[n.v] < dist[next.v]) {
                    dist[next.v] = next.w + dist[n.v];
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        // System.out.println(Arrays.toString(dist));
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
}