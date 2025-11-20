import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[m+2][n+2];     
        
        for(int i = 0; i < puddles.length; i++) {
            arr[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        arr[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] == -1) continue;
                
                int leftR = i;
                int leftC = j - 1;  
                
                if(arr[leftR][leftC] > 0) arr[i][j] += arr[leftR][leftC] % 1000000007;  
                
                int upperR = i - 1;
                int upperC = j;
                
                if(arr[upperR][upperC] > 0) arr[i][j] += arr[upperR][upperC] % 1000000007;  
            }
        }
        
        // for(int[] a : arr) System.out.println(Arrays.toString(a));
        
        return arr[m][n] % 1000000007;
    }
}