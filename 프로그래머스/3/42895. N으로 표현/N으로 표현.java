import java.util.*;

class Solution {
    public int solution(int N, int number) {
        //모든 경우의 수  + - / * 다 구하기
        
        //9이상이면 답은 -1이기 때문에 8까지만 보면 된다.
        Set<Integer>[] dp = new HashSet[9];
        
        for(int i = 0; i < 9; i++) {
            dp[i] = new HashSet();
        }
        
        for(int i = 1; i < 9; i++) {
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        
        //dp 돌면서 i개로 만들 수 있는 경우의 수 다 구하기
        for(int i =1; i < 9; i++) {
            //j, j-1 짝꿍 만들어서 모든 경우의 수 넣어줄거임
            for(int j = 1; j < i; j++) {
                
                for(int a : dp[j]) {
                    for(int b : dp[i-j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if(b != 0) dp[i].add(a / b);
                    }
                }
                
            }
        }
        
        int answer = -1;
        //number 있는지 확인하고 있으면 답
        for(int i = 1; i < 9; i++) {
            if(dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}