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

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N이 M 이하면 바로 답
        if(N <= M) {
            System.out.println(N);
            return;
        }

        // 이분 탐색으로 N명 이상 타는 최소 시간 찾기
        long left = 0;
        long right = 2000000000L * 30L;
        long time = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = M; // 0분에 M명이 탐

            for(int i = 0; i < M; i++) {
                cnt += mid / arr[i];
            }

            if(cnt >= N) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // (time-1)초까지 탄 사람 수
        long count = M;
        for(int i = 0; i < M; i++) {
            count += (time - 1) / arr[i];
        }

        // time초에 타는 사람들 중에서 N번째 찾기
        for(int i = 0; i < M; i++) {
            if(time % arr[i] == 0) {
                count++;
                if(count == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}