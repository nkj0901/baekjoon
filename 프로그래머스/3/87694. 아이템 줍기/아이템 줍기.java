import java.util.*;

class Solution {
    
    static class Node{
        int r;
        int c;
        int cnt;
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int L = rectangle.length;
        int[][] arr = new int[102][102];
        int arrL = arr.length;
        
        for(int i = 0; i < L; i++) {
            int[] curArr = rectangle[i];
            for(int l = curArr[0]*2; l <= curArr[2]*2; l++) {
                for(int r = curArr[1]*2; r <= curArr[3]*2; r++) {
                    arr[l][r]=1;
                }
            }
        }
        int[] dr1 = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc1 = {-1, 0, 1, 1, 1, 0, -1, -1};
        //길 체크
        for(int i = 0; i < arrL; i++) {
            for(int j = 0; j < arrL; j++) {
                if(arr[i][j] == 1) {
                    for(int d = 0; d < 8; d++) {
                        int nr = i + dr1[d];
                        int nc = j + dc1[d];
                        if(nr < 0 || nc < 0 || nr >= arrL || nc >= arrL) continue;
                        if(arr[nr][nc] == 0) {
                            arr[i][j] = 2;
                            break;
                        }
                    }
                }
            }
        }
        
        // for(int[] a : arr) {
        //     System.out.println(Arrays.toString(a));
        // }
        
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(characterX*2, characterY*2, 0));
        
        int[] dr2 = {-1, 0, 1, 0};
        int[] dc2 = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            //다시 방문하지 않도록 체크
            arr[n.r][n.c] = 1;
            
            if(n.r == itemX*2 && n.c == itemY*2) {
                answer = n.cnt/2;
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                //2인 애들 다 넣어주기
                int nr = n.r + dr2[d];
                int nc = n.c + dc2[d];
                if(nr < 0 || nc < 0 || nr >= arrL || nc >= arrL) continue;
                if(arr[nr][nc] == 2) {
                    queue.add(new Node(nr, nc, n.cnt+1));
                }
            }
        }
    
        return answer;
    }
}