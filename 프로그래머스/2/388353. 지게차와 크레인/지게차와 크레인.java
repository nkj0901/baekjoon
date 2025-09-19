import java.util.*;
import java.io.*;

class Solution {
    
    char[][] arr;
    int n, m;
    boolean canOut;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        //strage 2차원 배열로 바꾸기
        arr = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++) {
            //크레인
            if(requests[i].length() == 2) {
                deleteAll(requests[i].charAt(0));
            }
            //지게차
            else {
                canAccess(requests[i].charAt(0));
            }
        }
        
        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        
        //남은 것 세기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != '-') answer++;
            }
        }
        
        return answer;
    }
    
    //다 지우기
    private void deleteAll(char c) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if( arr[i][j] == c ) {
                    arr[i][j] = '-';
                }
            }
        }
    }
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    private void canAccess(char c) {
        boolean[][] delete = new boolean[n][m];
        
        // c 찾아서 사방 탐색하기 테두리에 있거나 밖으로 통해있으면 삭제
        for(int i = 0; i < n; i++) {
            loop:for(int j = 0; j < m; j++) {
                
                if(arr[i][j] != c) continue; 

                boolean[][] visited = new boolean[n][m];
                canOut = false;
                dfs(visited, i, j);
                if(canOut) delete[i][j] = true;                    
            }
        }      
        
        for(int i = 0; i < n; i++)  {
            for(int j = 0; j < m; j++) {
                if(delete[i][j]) arr[i][j] = '-';
            }
        }
    }
    
    private void dfs(boolean[][] visited, int r, int c) {      
        
        if(r <= 0 || c <= 0 || r >= n-1 || c >= m-1) {
            canOut = true;
            return;
        }
        
        if(visited[r][c]) return;
        visited[r][c] = true;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(arr[nr][nc] != '-') continue;

            dfs(visited, nr, nc);
        }
    }
}