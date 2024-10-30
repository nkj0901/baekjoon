import java.util.*;
import java.io.*;

class Solution {
    
    class Node {
        int e;
        int w;
        int intensity;
        
        Node(int e, int w , int intensity) {
            this.e = e;
            this.w = w;
            this.intensity = intensity;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {0, Integer.MAX_VALUE};
        
        List<Node>[] adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<Node>();
        }
        
        for(int i = 0; i < paths.length; i++) {
            adjList[paths[i][0]].add(new Node(paths[i][1], paths[i][2], 0));
            adjList[paths[i][1]].add(new Node(paths[i][0], paths[i][2], 0));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.intensity - o2.intensity;
            }
        });
        boolean[] visited = new boolean[n+1];
        
        // 출입구들에서 갈 수 있는 곳을 다 넣는다.
        for(int i = 0; i < gates.length; i++) {
            visited[gates[i]] = true;
            for(int j = 0; j < adjList[gates[i]].size(); j++) {
                Node node = adjList[gates[i]].get(j);
                pq.add(new Node(node.e, node.w, node.w));  
            }
        }
       
        while(!pq.isEmpty()) {
            Node cn = pq.poll();
            // System.out.println(cn.e + " " + cn.w + " " + cn.intensity);
            // System.out.println(Arrays.toString(answer));
            
            //방문했으면 continue
            if(visited[cn.e]) continue;
            visited[cn.e] = true;
            
            //산봉우리이면
            if(contains(summits, cn.e)) {
                if(answer[1] > cn.intensity) {
                    answer[0] = cn.e;
                    answer[1] = Math.min(answer[1], cn.intensity);
                } else if (answer[1] == cn.intensity) answer[0] = Math.min(answer[0], cn.e);
                continue;
            }
            
            for(int i = 0; i < adjList[cn.e].size(); i++) {
                Node nextNode = adjList[cn.e].get(i);
                pq.add(new Node(nextNode.e, nextNode.w, Math.max(nextNode.w, cn.intensity)));
            }    
        }
       
        return answer;
    }
    
    public boolean contains(int[] arr, int e) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == e) {
                return true;
            }
        }
        return false;
    }
}