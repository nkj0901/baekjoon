import java.util.*;
import java.io.*;

class Solution {
    
    int[][] arr;
    
    class Node implements Comparable<Node> {
        int cnt, r, c;
        
        Node(int cnt, int r, int c) {
            this.cnt = cnt;
            this.r = r;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o1) {
            return this.cnt - o1.cnt;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        arr = new int[102][102];
        
        for(int i = 0; i < rectangle.length; i++) {
            for(int x = rectangle[i][0] * 2; x <= rectangle[i][2] * 2; x++) {
                for(int y = rectangle[i][1] * 2; y <= rectangle[i][3] * 2; y++) {
                    arr[x][y] = 1;
                }
            }
        }
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        //외부 2로 다 만들어주기 (안에 구멍이 있을 때를 구별하기 위해)
        boolean[][] visited = new boolean[102][102];
        Queue<Node> q = new LinkedList();
        q.add(new Node(0, 0, 0));
        
        while(!q.isEmpty()) {
            Node n = q.poll();
                        
            if(visited[n.r][n.c]) continue;
            visited[n.r][n.c] = true;

            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= 102 || nc >= 102) continue;
                if(arr[nr][nc] != 0) continue;
                arr[nr][nc] = 2;
                q.add(new Node(0, nr, nc));
            }
        }
        // for(int i = 0; i < 30; i++) {
        //     for(int j = 0; j < 30; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        visited = new boolean[102][102]; 
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(0, characterX * 2, characterY * 2));
        
        
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            
            if(n.r == itemX * 2 && n.c == itemY * 2) {
                answer = n.cnt/2;
                break;
            }
            
            if(visited[n.r][n.c]) continue;
            visited[n.r][n.c] = true;
            
            // System.out.println(n.r + " " + n.c + " cnt : " + n.cnt);
            
            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                
                //1 아니면 패스
                if(arr[nr][nc] != 1)  continue;
                //테두리 아니면 패스
                if(!isOutline(nr, nc)) continue; 
                pq.add(new Node(n.cnt+1, nr, nc));
            }
      
        }
        
        
        return answer;
    }
    
    private boolean isOutline(int r, int c) {
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        
        for(int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(arr[nr][nc] == 2) return true;
        }
        
        return false;        
    }
}