import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        
        int[][] dp = triangle.clone();
        for(int i = h-2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}