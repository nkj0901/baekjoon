import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseNum = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            if(s == -1 && e == -1) break;

            int answer = 0;

            int plus = 2;
            int tri = 1;

            while(true) {
                tri+=plus;
                plus++;
                if(tri >= e) break;
                if(Math.sqrt(tri+1) % 1 == 0 && tri > s) answer++;
            }

            System.out.println("Case " + caseNum + ": " + answer);
            caseNum++;
        }
    }
}