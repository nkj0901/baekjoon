import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();

        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        loop: for(int i = N-1; i >= 0; i--) {
            for(int j = i-1; j >= 0; j--) {
                if(set.contains(arr[i]-arr[j])) {
                    System.out.println(arr[i]);
                    break loop;
                }
            }
        }
    }
}
