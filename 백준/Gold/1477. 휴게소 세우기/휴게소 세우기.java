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
        int L = Integer.parseInt(st.nextToken());


        int[] arr = new int[N+2];

        if(N != 0) st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N+1] = L;

        Arrays.sort(arr);


        int l = 1;
        int r = L;
        int mid, cnt;

        while(l <= r) {
            mid = (l+r)/2;

            cnt = 0;

            for(int i = 1; i <= N+1; i++) {
                cnt+=(arr[i]-arr[i-1]-1)/mid;
                if(cnt > M) break;
            }
            if(cnt > M) l = mid+1;
            else r = mid-1;
        }
        System.out.println(l);
    }
}