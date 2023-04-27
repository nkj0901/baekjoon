import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int answer = 0;

        loop: for(int i = 0; i <= m-(n*2+1); i++){
            if(s.charAt(i) == 'I') {
                for (int j = 1; j < n*2+1; j++){
                    if(j%2 == 1){
                        if(s.charAt(i+j) != 'O') continue loop;
                    }else{
                        if(s.charAt(i+j) != 'I') continue loop;
                    }
                }
                answer++;
            }
        }
        System.out.println(answer);
    }
}