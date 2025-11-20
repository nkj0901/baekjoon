import java.io.*;
import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int N = arr.length;
        int L = N/2 + 1;
        
        //연산자 배열
        String[] op = new String[N/2];
        //숫자 배열
        int[] number = new int[N/2 + 1];
        int[][] max = new int[N][N];
        int[][] min = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        
        //연산자 넣기
        int idx = 0;
        for(int i = 1; i < N; i+=2) {
            op[idx] = arr[i];
            idx++;
        }
        
        idx = 0;
        for(int i = 0; i < N; i+=2) {
            number[idx] = Integer.parseInt(arr[i]);
            idx++;
        }
        
        // 숫자 몇개씩 볼건지
        for(int step = 0; step < L; step++) {
            
            //시작 인덱스
            for(int i = 0; i < L-step; i++) {

                if(step == 0) {
                    max[i][i] = number[i];
                    min[i][i] = number[i];
                }
                
                int j = i + step;
                
                //연산자 괄호 "(" 넣는 위치
                for(int k = i; k < j; k++) {
                    //"+"이면
                    if(op[k].equals("+")) {
                        //i부터 K 까지 k부터 j까지로 조개서 더해봐서 가장 큰 거/작은 거 저장
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);
                    }
                    //"-"이면
                    else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);
                    }
                    
                }
            }
        }
        
        return max[0][L-1];
    }
}