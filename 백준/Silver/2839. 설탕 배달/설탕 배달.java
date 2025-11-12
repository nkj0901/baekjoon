import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, 5001);
        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 1;

        for(int i = 3; i <= N; i++) {
            dp[i] = Math.min(dp[i], dp[i-3] + 1);
        }

        for(int i = 5; i <= N; i++) {
            dp[i] = Math.min(dp[i], dp[i-5] + 1);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N] == 5001 ? -1 : dp[N]);
    }
}