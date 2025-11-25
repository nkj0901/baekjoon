import java.util.*;

class Solution {
    
    class Node {
        int r, c, cnt;
        
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Integer.compare(a.cnt,b.cnt));
        boolean[][] visited = new boolean[N][M];
        pq.add(new Node(0, 0, 1));
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            
            if(n.r == N-1 && n.c == M-1) {
                answer = n.cnt;
                break;
            }
            
            if(visited[n.r][n.c]) continue;
            visited[n.r][n.c] = true;
            
            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(maps[nr][nc] == 0) continue;
                pq.add(new Node(nr, nc, n.cnt + 1));
            }
        }
        
        //갈 수 없는 경우 -1 처리
        return answer;
    }
}