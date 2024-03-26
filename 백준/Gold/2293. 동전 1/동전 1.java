import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            for(int j = 1; j <= k; j++) {
                if(num <= j) {
                    dp[j]+=dp[j-num];
                }
            }
        }
        System.out.println(dp[k]);
    }
}