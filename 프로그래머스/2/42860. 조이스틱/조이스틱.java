import java.io.*;
import java.util.*;

class Solution {
    String name;
    int minMove, l;
    boolean[] visited;
    
    public int solution(String name) {
        int answer = 0;
        this.name = name;
        minMove = Integer.MAX_VALUE;
        l = name.length();
        visited = new boolean[l];
        
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(0) + "");
        visited[0] = true;
        for(int i = 1; i < l; i++) {
            sb.append("A");
        }
        
        dfs(0, 0, sb , "");
        int count = changeCount();
        answer = minMove + count;
        
        // System.out.println(minMove);
        // System.out.println(count);
        
        return answer;
    }
    
    public void dfs(int move, int idx, StringBuilder sb, String str) {
        // System.out.println("str : " + str);
        // System.out.println("move : " + move);
        // System.out.println("sb : " + sb);
        // System.out.println("_________________________");
        
        if(sb.toString().equals(name)) {
            minMove = Math.min(minMove, move);
            return;
        }
        
        if(move > minMove) return;
        
        // 오른쪽으로 이동 가장 가까운 애 찾기
        int right = 0;
        int rightI = 0;
        for(int i = 1; i < l; i++) {
            right = (idx + i) % l;
            rightI = i;
            if(name.charAt(right) == 'A' || visited[right]) continue;
            break;
        }
        
        // 왼쪽으로 이동 가장 가까운 애 찾기
        int left = 0;
        int leftI = 0;
        for(int i = 1; i < l; i++) {
            left = (idx - i + l) % l;
            leftI = i;
            if(name.charAt(left) == 'A' || visited[left]) continue;
            break;
        }
        
        //들리지 않았다면 들리기         
        StringBuilder nextSB = new StringBuilder(sb.toString());
        nextSB.replace(right, right + 1, name.charAt(right) + "");
        if(!visited[right]) {
            visited[right] = true;
            dfs(move + rightI, right, nextSB, str + right + "");
            visited[right] = false;
        }
        
        //들리지 않았다면 들리기
        StringBuilder beforeSB = new StringBuilder(sb.toString());
        beforeSB.replace(left, left + 1, name.charAt(left) + "");
        sb.replace(left, left+1, name.charAt(left) + "");
        if(!visited[left]) {
            visited[left] = true;
            dfs(move + leftI, left, beforeSB, str + left + "");        
            visited[left] = false;
        }
           
    }
    
    public int changeCount() {
        int count = 0;
        for(int i = 0; i < l; i++) {
            // System.out.println(name.charAt(i));
            // System.out.println(name.charAt(i) - 'A');
            if(name.charAt(i) == 'A') continue;
            else {
                int nth = name.charAt(i) - 'A';
                count += Math.min(nth, 90 - name.charAt(i) + 1);
            }
        }
        return count;
    }
}