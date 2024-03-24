import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int L;
    static String testCase;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {

            testCase = br.readLine();
            L = testCase.length()+2;

            check = true;
            dfs((L/2)/2, L/2);

            if(check) System.out.println("YES");
            if(!check) System.out.println("NO");
        }
    }

    private static void dfs(int now, int next) {
        if(now <= 0) return;
        if(!check) return;


        int pre = testCase.charAt(now-1)  == 0 ? 1 : 0;
        for(int i = now; i < L-1; i+=next) {
            if(pre == testCase.charAt(i-1)) {
                check = false;
                return;
            }
            pre = testCase.charAt(i-1);
        }
        dfs(now/2, next/2);
    }
}