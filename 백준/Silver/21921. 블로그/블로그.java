import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int i = 0; i < X; i++){
            sum+=arr[i];
        }

        int max = sum;
        map.put(max, map.getOrDefault(max, 0)+1);

        for(int i = 0; i < N-X; i++){
            sum-=arr[i];
            sum+=arr[i+X];
            map.put(sum, map.getOrDefault(sum, 0)+1);
            max = Math.max(max, sum);
        }

        if(max == 0) System.out.println("SAD");
        else System.out.println(max + " " +  map.get(max));
    }
}