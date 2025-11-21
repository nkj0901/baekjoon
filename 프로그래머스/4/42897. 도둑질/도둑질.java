import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        
        // int[] start = new int[N];
        int[] dp = new int[N];

        //start 정해보기 s는 무조건 포함
        for(int s = 0; s < 2; s++){
            
            dp[s] = money[s];
            // start[s] = s;
            
            for(int idx = s+1; idx < s+N; idx++) {
                int i = idx%N;    
                
                // System.out.println("______________________");
                // System.out.println(i);
                int prev1 = i-1 < 0 ? N+(i-1) : i-1;
                int prev2 = i-2 < 0 ? N+(i-2) : i-2;
                // System.out.println(prev1);
                // System.out.println(prev2);
                //만약 idx 0과 1 비교할 때
                if(i == s + 1) {
                    //0이 더 클 때
                    if(money[i-1] > money[i]) {
                        dp[i] = money[prev1];
                        // start[i] = start[prev1];
                    } 
                    // 1이 더 크거나 같을 때
                    else {
                        dp[i] = money[i];
                        // start[i] = i;
                    }
                }

                else{
                    // //마지막일 때는 값 구하기
                    // if(idx == s+N-1) {
                    //     //선택하지 않을 때 값
                    //     int noselect = dp[prev1];
                    //     int select = 0;
                    //     //0번째까 포함되어 있으면 빼고 계산해야 함
                    //     if(start[prev2] == 0) {
                    //         select = dp[prev2] + money[i] - money[0];
                    //     }
                    //     dp[i] = Math.max(noselect, select);
                    // }
                    //이 아이를 선택하는 것이 좋을 때
                    // else 
                        if(dp[prev2] + money[i] > dp[prev1]) {
                        dp[i] = dp[prev2] + money[i];
                        // start[i] = start[prev2];
                    } 
                    // 선택 안할 때 또는 상관없을 때
                    else {
                        //여기도 1포함되어 있으면 처리
                        dp[i] = dp[prev1];
                        // if(dp[prev2] + money[i] == dp[prev1]) start[i] = s+1;
                        // else start[i] = start[prev1];
                    }
                }
            }
            // System.out.println(Arrays.toString(start));
            // System.out.println(Arrays.toString(dp));
            int tmpAnswer = s-2;
            answer = Math.max(answer, dp[tmpAnswer < 0 ? N+(s-2) : tmpAnswer]);
            }
        return answer;
    }
}