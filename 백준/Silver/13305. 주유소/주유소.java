import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] dist = new int[N];
        int answer = 0;

        for(int i = 1; i < N; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] city = new int[N+1];
        for(int i = 1; i < N; i++){
            city[i] = Integer.parseInt(st.nextToken());

            if(i == 1) answer+=city[i]*dist[i];
            else if(city[i-1] > city[i]) answer+=city[i]*dist[i];
            else answer+=city[i-1]*dist[i];
        }
        System.out.println(answer);
    }
}