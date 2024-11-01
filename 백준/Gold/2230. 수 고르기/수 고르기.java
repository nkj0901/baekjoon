import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = 1;

        int answer = Integer.MAX_VALUE;

        while(true) {

            if(s == N || e == N) break;
            if(s > e) break;

            int sub = Math.abs(arr[e] - arr[s]);
            if(sub < M) {
                e++;
            } else if (sub > M) {
                answer = Math.min(answer, sub);
                s++;
            }
            else {
                answer = M;
                break;
            }
        }

        if(answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);
    }
}