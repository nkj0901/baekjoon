import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] height = new int[N+1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            height[i] = num;
        }

        for(int i = 0; i <= N; i++) {
            while(!stack.isEmpty() && stack.peek() > height[i]){
                stack.pop();
                answer++;
            }
            if(!stack.isEmpty() && stack.peek() == height[i]) continue;

            stack.add(height[i]);
        }
        System.out.println(answer);
    }
}