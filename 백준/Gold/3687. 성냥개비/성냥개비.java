import java.io.*;
import java.util.Arrays;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minDp = new String[101];

        minDp[2] = "1";
        minDp[3] = "7";
        minDp[4] = "4";
        minDp[5] = "2";
        minDp[6] = "6";
        minDp[7] = "8";
        minDp[8] = "10";

        String[] num = {"1", "7", "4", "2", "0", "8"};

        //최소값
        String min;
        for(int i = 9; i <= 100; i++) {
            for(int j = 2; j <= 7; j++) {
                min = minDp[i-j]+num[j-2];
                if(minDp[i] == null) minDp[i] = min;
                minDp[i] = valueOf(Math.min(Long.parseLong(minDp[i]), Long.parseLong(min)));
            }
        }

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            int tmp = cur;

            //최대값
            String max = "";
            if(cur%2 != 0) {
                max += "7";
                tmp-=3;
            }
            for(int j = 2; j <= tmp; j+=2) {
                max = max+"1";
            }
            System.out.println(minDp[cur] + " " + max);
        }
    }
}