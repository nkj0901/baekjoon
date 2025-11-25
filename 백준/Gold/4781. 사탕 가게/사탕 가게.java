import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) (Float.parseFloat(st.nextToken()) * 100 + 0.5f);

            if(n == 0) break;

            int[][] candy = new int[n][2];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                //칼로리
                candy[i][0] =  Integer.parseInt(st.nextToken());
                candy[i][1] = (int) (Float.parseFloat(st.nextToken()) * 100 + 0.5f);
            }
            int[] dp = new int[m+1];
            int answer = 0;
            //i원으로 만들 수 있는 최고의 칼로리
            for(int i = 0; i < m+1; i++) {
                for(int j = 0; j < n; j++) {
                    if(i - candy[j][1] >= 0) dp[i] = Math.max(dp[i], dp[i-candy[j][1]] + candy[j][0]);
                    answer = Math.max(answer, dp[i]);
                }
            }

            System.out.println(answer);
        }
    }
}