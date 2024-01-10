import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int cover = 0;
        int answer = 0;
        int num = 0;
        int l;
        for(int i = 0; i < N; i++){
            if(cover >= arr[i][0]) arr[i][0]+=(cover-arr[i][0]);
            l = arr[i][1]-arr[i][0];
            if(l <= 0) continue;
            num+=l/L;
            if(l%L != 0) {
                num++;
            }
            cover=arr[i][0]+(num*L);
            answer+=num;
            num=0;
        }
        System.out.println(answer);
    }
}
