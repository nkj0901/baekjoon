import java.util.*;
import java.io.*;

class Solution {
    Map<String, Integer> map;
    int cnt;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        map = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++) {
            int start = routes[i][0] - 1;
            int r = points[start][0];
            int c = points[start][1];
            cnt = 0;
            
            String str = r + " " + c + " " + cnt;
            addMap(str);
            
            for(int j = 1; j < routes[i].length; j++) {
                int next = routes[i][j] - 1;
                int nextR = points[next][0];
                int nextC = points[next][1];
                
                addMap(r, nextR, c, nextC);
                
                r = nextR;
                c = nextC;
            }
        }
        
        Iterator<Map.Entry<String, Integer>> entry = map.entrySet().iterator();
        while(entry.hasNext()) {
            Map.Entry<String, Integer> element  = entry.next();
            if(element.getValue() > 1) answer++;
        }
        
        return answer;
    }
    
    private void addMap(int startR, int endR, int startC, int endC) {
        
        if(startR > endR) {
            for(int i = 0; i < startR - endR; i++) {
                int nextR = startR - (i + 1);
                String str = nextR + " " + startC + " "  + (++cnt);
                addMap(str);
            }
        } 
        
        else if(endR > startR) {
             for(int i = 0; i < endR - startR; i++) {
                int nextR = startR + i + 1;
                String str = nextR + " " + startC + " " + (++cnt);
                addMap(str);
            }
        }
        
        if(startC > endC) {
            for(int i = 0; i < startC - endC; i++) {
                int nextC = startC - (i + 1);
                String str = endR + " " + nextC + " "  + (++cnt);
                addMap(str);
            }
        } 
        
        else if(endC > startC) {
             for(int i = 0; i < endC - startC; i++) {
                int nextC = startC + i + 1;
                String str = endR + " " + nextC + " " + (++cnt);
                addMap(str);
            }
        }
    }
                       
    private void addMap(String str) {
        if(map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        } else map.put(str, 1);
        // System.out.println(str);
    }
}