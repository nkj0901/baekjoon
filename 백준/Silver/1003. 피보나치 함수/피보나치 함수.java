import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] memo = new int[2][N+3];

            memo[0][0] = 1;
            memo[1][1] = 1;

            for(int i = 2; i <= N; i++) {
                memo[0][i] = memo[0][i-1] + memo[0][i-2];
                memo[1][i] = memo[1][i-1] + memo[1][i-2];
            }

            System.out.println(memo[0][N] + " " + memo[1][N]);
        }
    }
}
