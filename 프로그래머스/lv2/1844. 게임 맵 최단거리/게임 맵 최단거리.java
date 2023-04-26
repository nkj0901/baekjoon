import java.util.*;

class Node {
    int r, c, cnt;
    
    Node(int r, int c, int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int r = maps.length;
        int c = maps[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,1));
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        boolean check = false;
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            
            if(n.r == r-1 && n.c == c-1) {
                answer = n.cnt;
                check = true;
                break;
            }
            
            if(visited[n.r][n.c]) continue;
            visited[n.r][n.c] = true;
            // System.out.println(n.r + " " + n.c + " " + n.cnt);
            
            for(int d = 0; d < 4; d++){
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
    
                if( nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;
                
                queue.offer(new Node(nr, nc, n.cnt+1));               
            }
        }     
        if( !check ) answer = -1;
        return answer;
    }
}