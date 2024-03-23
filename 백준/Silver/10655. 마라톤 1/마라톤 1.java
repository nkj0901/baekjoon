import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(i != 0) sum+=Math.abs(arr[i-1][0] - arr[i][0]) + Math.abs(arr[i-1][1] - arr[i][1]);
        }

        //하나씩 빼보기
        int max = Integer.MIN_VALUE;
        int ori = 0;
        int jump = 0;
        int gap = 0;
        for (int i = 0; i < N-2; i++) {

            //다음 그대로 가보기
            ori = Math.abs(arr[i][0] - arr[i+1][0]) + Math.abs(arr[i][1] - arr[i+1][1])
                    + Math.abs(arr[i+1][0] - arr[i+2][0]) + Math.abs(arr[i+1][1] - arr[i+2][1]);

            //하나 건더 뛰어보기
            jump = Math.abs(arr[i][0] - arr[i+2][0]) + Math.abs(arr[i][1] - arr[i+2][1]);

            gap = ori - jump;

            if(gap > max) {
                max = gap;
            }
        }
        System.out.println(sum-max);
    }
}