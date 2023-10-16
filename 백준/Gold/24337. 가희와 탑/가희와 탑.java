import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a+b > N+1) {
            System.out.print(-1);
            return;
        }

        int[] arr = new int[N];

        //왼쪽 채우기
        for(int i = 0; i < a-1; i++) {
            arr[i] = i+1;
        }
        arr[a-1] = Math.max(a, b);
        if(a > 1) arr[a-1] = 1;

        //중간 채우기
        for(int i = a; i < N-b; i++) {
            arr[i] = 1;
        }

        //오른쪽 채우기
        arr[N-b] = Math.max(a, b);
        if(a == 1 && b != N) arr[N-b] = 1;
        for(int i = N-1; i > N-b; i--) {
            arr[i] = N-i;
        }

        //1을 앞으로 다 빼기
        for(int i = 1; i < N-1; i++) {
            if(arr[i] == 1) {
                for(int j = i; j >= 1; j--) {
                    arr[j] = arr[j-1];
                }
                arr[1] = 1;
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}