import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        memo = new Long[N][N];

        for(Long[] l : memo){
            Arrays.fill(l, -1L);
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(memo[0][0]);
    }

    static int N;
    static int[][] arr;
    static Long[][] memo;

    static Long dfs(int r, int c) {
        if (r == N - 1 && c == N - 1) return 1L;
        if (r >= N || c >= N) return 0L;
        if (arr[r][c] == 0) return 0L;
        if (memo[r][c] != -1L) return memo[r][c];

        int nr = r + arr[r][c];
        int nc = c + arr[r][c];

        return memo[r][c] = dfs(nr, c) + dfs(r, nc);
    }
}