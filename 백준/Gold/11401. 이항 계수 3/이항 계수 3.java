import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long p = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        //분자
        long sun = factorial(N);

        //분모
        long mother = factorial(K) * factorial(N-K) % p;

        //분모의 역원구하기
        long answer = sun * pow(mother, p-2) % p;

        System.out.println(answer);
    }

    private static long factorial(long number) {
        long fac = 1;

        while(number > 1) {
            fac = (fac * number) % p;
            number--;
        }
        return fac;
    }

    private static long pow(long base, long expo) {
        if(expo == 1) {
            return base % p;
        }

        long temp = pow(base, expo/2);

        if(expo % 2 == 1) {
            return (temp * temp % p) * base % p;
        }
        
        return temp * temp % p;
    }
}