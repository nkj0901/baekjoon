import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] str = new String[N];

        for(int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < N-7; i++) {
            for(int j = 0; j < M-7; j++) {
                //(i,j)을 시작으로 8*8 보기
                answer = Math.min(getCnt(str, i, j, 'W'), answer);
                answer = Math.min(getCnt(str, i, j, 'B'), answer);
            }
        }
        System.out.println(answer);
    }

    private static int getCnt(String[] str, int n, int m, char cur) {
        int cnt = 0;
        for(int i = n; i < n + 8; i++) {
            cur = cur == 'W' ? 'B' : 'W';
            for (int j = m; j < m + 8; j++) {
                if (cur == str[i].charAt(j)) {
                    cnt++;
                    cur = str[i].charAt(j) == 'W' ? 'B' : 'W';
                    continue;
                }
                cur = str[i].charAt(j);
            }
        }
        return cnt;
    }
}