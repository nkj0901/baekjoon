import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int[] sel;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sel = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combi(0, 0);
        System.out.println(sb);
    }

    private static void combi(int idx, int sidx) {

        if (M == sidx) {
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sel[sidx] = arr[i];
            combi(i+1, sidx+1);
            visited[i] = false;
        }
    }
}