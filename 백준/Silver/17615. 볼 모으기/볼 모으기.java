import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int min = Integer.MAX_VALUE;

        char last = str.charAt(str.length()-1);

        boolean check = false;
        int cnt = 0;
        for(int i = N-2; i >= 0; i--){
            if(str.charAt(i) != last){
                check = true;
            }
            if(check){
                if(str.charAt(i) == last){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);

        check = false;
        cnt = 0;
        for(int i = N-2; i >= 0; i--){
            if(str.charAt(i) != last){
                cnt++;
            }
        }
        min = Math.min(min, cnt);
        System.out.println(min);
    }
}