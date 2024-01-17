import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long answer = 0;
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            answer+=Math.abs(arr[i]-(i+1));
        }
        System.out.println(answer);
    }
}