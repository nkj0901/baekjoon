import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int[] arr = new int[X+1];
        int[] size = new int[X+1];

        for(int i = 2; i <= X; i++) {
        int min = Integer.MAX_VALUE;

            if(i % 3 == 0) {
                if(min > size[i/3]){
                    min = size[i/3];
                    size[i] = min+1;
                    arr[i] = i/3;
                }
            }
            if(i % 2 == 0) {
                if(min > size[i/2]) {
                    min = size[i/2];
                    size[i] = min+1;
                    arr[i] = i/2;

                }
            }
            if(min > size[i-1]) {
                size[i] = size[i-1] + 1;
                arr[i] = i-1;
            }
        }

        sb.append(size[X] + "\n");

        int cur = X;
        while(true) {
            if(cur == 0) break;
            sb.append(cur + " ");
            cur = arr[cur];
        }

        System.out.println(sb);
    }
}