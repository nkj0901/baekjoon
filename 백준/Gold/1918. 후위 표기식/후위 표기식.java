import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == ')') {
                while(true) {
                    char cur = stack.pop();
                    if(cur == '(') break;
                    else sb.append(cur);
                }
            } else {
                while (!stack.isEmpty() && c != '('&& stack.peek() != '(' && priority(stack.peek()) >= priority(c)) {
                    char cur = stack.pop();
                    sb.append(cur);
                    if(stack.isEmpty() || cur == '(') break;
                }
                stack.add(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    public static int priority(char c) {
        if(c == '*' || c == '/') return 2;
        else return 1;
    }
}
