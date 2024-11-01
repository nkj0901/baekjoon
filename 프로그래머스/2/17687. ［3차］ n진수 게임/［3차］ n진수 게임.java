import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int curInt = 0;
        
        while(sb.length() <= (t * m)) {
            String changeString = Integer.toString(curInt, n);
            // System.out.println(changeString);
            sb.append(changeString);
            curInt++;
        }
        System.out.println(sb);
        
        StringBuilder sbAns = new StringBuilder();
        int index = p-1;
        for(int i = 1; i <= t; i++) {
            sbAns.append(sb.charAt(index));
            index+=m;
        }
        String answer = sbAns.toString().toUpperCase();
        return answer;
    }
}