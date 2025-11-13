import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int[] dp = new int[k+1];
        dp[0] = 0;
        int INF = 50001;

        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k+1; j++) {
                if(j < coins[i]) continue;
                dp[j] = dp[j-coins[i]] + (dp[j] == INF ? 0 : dp[j]);
                if(j == coins[i]) dp[j]++;
            }
        }

        System.out.println(dp[k]);
    }
}