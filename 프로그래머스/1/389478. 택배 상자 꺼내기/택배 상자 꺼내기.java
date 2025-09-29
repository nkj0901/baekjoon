import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int h = n/w;
        if(n%w > 0) h++;
        
        int searchHeight = 0;
        int searchWidth = 0;
        
        int[][] arr = new int[h][w];
        
        for(int i = 0; i < n; i++) {
            int r = i/w;
            int c = i%w;
            //홀수면 인텍스 조정
            if(r % 2 != 0) {
                c = w - c - 1;
            }
            
            arr[r][c] = i + 1;
            if(num == i + 1) {
                searchHeight = r;
                searchWidth = c;
            }
        }
        
        for(int i = searchHeight; i < h; i++) {
            if(arr[i][searchWidth] != 0) answer++;
        }        
        
        return answer;
    }
}