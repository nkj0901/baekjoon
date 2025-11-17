import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        //*,/을 먼저 계산해주기 위한 stack들
        Stack<String> stack3 = new Stack<>();
        Stack<String> stack4 = new Stack<>();

        //stack1에 다 넣어놓기
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            stack1.add(String.valueOf(cur));
        }

        while(!stack1.isEmpty()) {
            String cur = stack1.pop();

            //괄호가 나오면 관호 안에꺼 먼저 계산해주기
            if (cur.equals("(")) {
                //"*", "/"먼저 계산해주기
                while(!stack2.isEmpty()) {
                    String str2 = stack2.pop();

                    //안에꺼 계산하기 위해 )가 나올 때까지 stack3에 넣어주기
                    if(str2.equals(")")) break;
                    //*,/는 먼저 계산해서 stack3에 넣어주기
                    if(str2.equals("*") || str2.equals("/")) {
                        String front= stack3.pop();
                        String back = stack2.pop();
                        str2 = front + back + str2;
                    }
                    stack3.add(str2);
                }

                //stack4 다 옮기기
                while(!stack3.isEmpty()) {
                    stack4.add(stack3.pop());
                }

                //stack4 후위식으로 바꿔서 stack1에 넣어주기
                StringBuilder col = new StringBuilder();
                col.append(stack4.pop());
                String op = "";
                while(!stack4.isEmpty()) {
                    String str2 = stack4.pop();

                    if(!op.equals("")) {
                        col.append(str2).append(op);
                        op = "";
                    } else if(str2.equals("+") || str2.equals("-")) {
                        op = str2;
                    }
                }

                stack1.add(col.toString());

                //stack2도 stack1로 돌려보내기
                while(!stack2.isEmpty()) {
                    stack1.add(stack2.pop());
                }
            }
            // 별일 없으면 그냥 stack2에 넣기
            else {
                stack2.add(cur);
            }

            //stack1다 봤으면 stack2 다 계산 때려보기
            if (stack1.isEmpty()){

                while(!stack2.isEmpty()) {
                    String str2 = stack2.pop();

                    //"*", "/"먼저 계산해주기
                    if(str2.equals("*") || str2.equals("/")) {
                        String front= stack3.pop();
                        String back = stack2.pop();
                        str2 = front + back + str2;
                    }
                    stack3.add(str2);
                }

                //stack4에 넣기
                while(!stack3.isEmpty()) {
                    stack4.add(stack3.pop());
                }

                //stack4 계산해주기
                StringBuilder col = new StringBuilder();
                col.append(stack4.pop());
                String op = "";
                while(!stack4.isEmpty()) {
                    String str2 = stack4.pop();

                    if(!op.equals("")) {
                        col.append(str2).append(op);
                        op = "";
                    } else if(str2.equals("+") || str2.equals("-")) {
                        op = str2;
                    }
                }
                stack2.add(col.toString());
            }
        }

        System.out.println(stack2.pop());
    }
}