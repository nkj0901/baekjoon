import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int max = 0;
        int sum = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(num, max);
            nums[i] = num;
            sum+=num;
        }

        int total = Integer.parseInt(br.readLine());

        if(total >= sum) System.out.println(max);
        else {
            while(true){
                max--;
                sum = 0;
                for(int i = 0; i < N; i++){
                    if(nums[i] <= max) sum+=nums[i];
                    else sum+=max;
                }
                if(sum <= total) {
                    System.out.println(max);
                    break;
                }
            }
        }
    }
}