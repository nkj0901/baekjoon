import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i >= 0; i--) {
            int cur = arr[i];
            if(stack.isEmpty()) {
                answer[i] = -1;
                stack.add(cur);
                continue;
            }

            while(!stack.isEmpty()){
                //cur 보다 작은 애들은 없애기
                if(cur >= stack.peek()) {
                    stack.pop();
                    if(stack.isEmpty()) answer[i] = -1;
                }
                //큰애 발견하면 답 저장하고 멈추기
                else {
                    answer[i] = stack.peek();
                    break;
                }
            }
            stack.add(cur);
        }
        for(int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}