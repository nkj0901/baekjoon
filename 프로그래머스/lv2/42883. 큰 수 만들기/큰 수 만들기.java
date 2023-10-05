import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while(!stack.isEmpty() && k-1 >= 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        answer = sb.toString();
        return answer;
    }
}