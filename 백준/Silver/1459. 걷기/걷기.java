import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());
        long answer = 0;

        if(X==0 && Y==1 || X==1 && Y==0) answer = W;
        else if(W*2 < S) {
            answer = X*W+Y*W;
        } else {
            long min = Math.min(X, Y);
            long max = Math.max(X, Y);
            if(S*2 < W*2) {
                //두 숫자의 차이가 짝수라면
                if (Math.abs(X - Y) % 2 == 0) answer = max * S;
                    //둘 사이의 차이가 홀수 라면
                else answer = (max - 1) * S + W;
            } else {
                answer = min*S + (max-min)*W;
            }
        }
        System.out.println(answer);
    }
}