import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int N, K, answer;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        sel = new int[N];
        answer = 0;

        perm(0);

        System.out.println(answer);
    }

    static void perm(int idx){
        if(idx == N) {
            int sum = 500;
            for(int i = 0; i < N; i++) {
                sum-=K;
                sum+=arr[sel[i]];
                if(sum < 500) break;
            }
            if(sum >= 500) answer++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            sel[idx] = i;
            perm(idx+1);
            visited[i] = false;
        }
    }
}