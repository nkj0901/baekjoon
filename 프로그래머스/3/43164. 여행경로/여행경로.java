import java.util.*;
import java.io.*;

class Solution {
    
    static String[] answer;
    static boolean[] useCheck;
    static boolean isAnswer;
    static int L;
    
    public String[] solution(String[][] tickets) {
        L = tickets.length;
        answer = new String[tickets.length + 1];
        useCheck = new boolean[L];
        
        //ticket 알파벳순으로 정렬
        Arrays.sort(tickets, (String[] o1, String[] o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        
        answer[0] = "ICN";
        isAnswer = false;
        dfs("ICN", 1, tickets);
        return answer;
    }
    
    private void dfs(String next, int cnt, String[][] tickets) {
        
        if(cnt > L) {
            isAnswer = true;
            return;
        }
        
        for(int i = 0; i < L; i++) {
            if(useCheck[i]) continue;
            if(tickets[i][0].equals(next)) {
                useCheck[i] = true;
                answer[cnt] = tickets[i][1];
                dfs(tickets[i][1], cnt+1, tickets);
                if(isAnswer) return;
                useCheck[i] = false;
            }
        }
    }
}