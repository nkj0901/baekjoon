import java.util.*;
import java.io.*;    
    
    
class Solution {
    
    class Node {
        String name;
        String idx;
        String visit;
        int cnt;
        
        Node(String name, String idx, String visit, int cnt) {
            this.name = name;
            this.idx = idx;
            this.visit = visit;
            this.cnt = cnt;
        } 
    }
    
    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        boolean[] visited = new boolean[n+1];
        
        
        List<String> list = new ArrayList();
        Queue<Node> q = new LinkedList();
        q.add(new Node("ICN", " ", "ICN", 0));
        
        //티켓 갯수만큼 돌면서 다음 갈 곳 찾기
        while(!q.isEmpty()) {
            
            Node cur = q.poll();
            
            if(cur.cnt == n) {
                // System.out.println(cur.visit);
                // System.out.println(cur.idx);
                list.add(cur.visit);
                continue;
            }
            
            //cur에서 출발하는 항공권 찾기
            for(int i = 0; i < n; i++) {

                if(cur.idx.contains(" " + i + " ")) continue;
                if(tickets[i][0].equals(cur.name)) {
                    q.add(new Node(tickets[i][1], cur.idx + i + " " , cur.visit + "_" + tickets[i][1], cur.cnt+1));
                }
            }           
        }
        
        Collections.sort(list);
        String[] ans = list.get(0).split("_");
        return ans;
    }
}