import java.util.*;
import java.io.*;

class Solution {
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        Arrays.sort(nodes);
        int maxNum = nodes[nodes.length-1] +1;
        
        List<Integer>[] adjList = new ArrayList[maxNum];
        
        for(int i = 0; i < nodes.length; i++) {
            adjList[nodes[i]] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        //각 노드들이 홀짝트리에 속해있는지 역홀짝 트리에 속해있는지 확인
        boolean[] normal = new boolean[maxNum];
        boolean[] reverse = new boolean[maxNum];
        
        Queue<Integer> q = new LinkedList<>();
        //재방문 방지
        boolean[] visited = new boolean[maxNum];
        //nodes의 모든 숫자를 돌면서 대장시켜주기(root)
        for(int i = 0; i < nodes.length; i++) {
            int num = nodes[i];
            if(visited[num]) continue;
            
            int nodeCnt = 0;
            
            int reverseChild = 0;
            int normalChild = 0;
            
            int reverseRoot = 0;
            int normalRoot = 0;

            q.add(num);
            
            //트리돌면서 홀짝인지 역홀짝인지 보기
            while(!q.isEmpty()) {
                int n = q.poll();
                
                if(visited[n]) continue;
                visited[n] = true;
                nodeCnt++;
                boolean state = n%2 == adjList[n].size()% 2;   
                //state가 true 이면 normal의 root이거나 reverse의 child이다
                if(state) {
                    normalRoot++; 
                    reverseChild++;
                } else {
                    reverseRoot++;
                    normalChild++;
                }
                for(int j = 0; j < adjList[n].size(); j++) {
                    q.offer(adjList[n].get(j));
                }
            }
            
            if(normalRoot == 1 && normalChild == nodeCnt -1) answer[0]++;
            if(reverseRoot == 1 && reverseChild == nodeCnt -1) answer[1]++;
        }
        
        return answer;
    }
}