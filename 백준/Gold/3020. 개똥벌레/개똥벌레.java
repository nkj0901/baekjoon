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
        int H = Integer.parseInt(st.nextToken());
        int[] up = new int[H+1];
        int[] down = new int[H+1];

        for(int i = 0; i < N; i+=2) {
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }

        //누적합 구하기
        for(int i = H; i > 1; i--) {
            up[i-1] += up[i];
            down[i-1] +=down[i];
        }

        for(int i = 1; i <= H/2; i++) {
            int tmp = up[i];
            up[i] = up[H-i+1];
            up[H-i+1] = tmp;
        }

        int sum;
        int min = Integer.MAX_VALUE;
        int cnt = 1;

        for(int i = 1; i <= H; i++) {
            sum = up[i] + down[i];
            if(sum < min) {
                min = sum;
                cnt = 1;
            } else if (sum == min) cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}