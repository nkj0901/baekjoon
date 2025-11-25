import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());

            //코인 하나씩 보면서 각 i원 만큼 몇 가지 경우의 수로 만들 수 있는지 보기
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for(int i = 0; i < N; i++) {
                for(int j = 1; j < target+1; j++) {
                    if(j - coin[i] < 0) continue;
                    else dp[j] = dp[j-coin[i]] + dp[j];
                }
            }

            System.out.println(dp[target]);
        }
    }
}