import java.util.*;
import java.io.*;

class Solution {
    int[][] game_board;
    int[][] table;
    int[][] table90;
    int[][] table180;
    int[][] table270;
    int N;
    
    class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        this.table = table;
        this.game_board = game_board;
        N = table.length;
        table90 = new int[N][N];
        table180 = new int[N][N];
        table270 = new int[N][N];
        
        //0, 90, 180, 270도 볼 거임
        for(int a = 0 ; a <= 3; a++) {
 
            int[][] curTable;
            boolean[][] visited = new boolean[N][N];
            
            if(a == 0) curTable = table;
            else if(a == 1) curTable = table90;
            else if(a == 2) curTable = table180;
            else curTable = table270;
            
//             System.out.println("--------------game_board----------------");
//             for(int[] t : game_board) System.out.println(Arrays.toString(t));
//             System.out.println("--------------------------------------");
            
//             System.out.println("--------------시작----------------");
//             System.out.println("--------------curTable----------------");
//             for(int[] t : curTable) System.out.println(Arrays.toString(t));
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    //이미 사용한 도형이거나 0이면 지나가기
                    // for(boolean[] b : visited) System.out.println(Arrays.toString(b));
                    // System.out.println();
                    if(curTable[i][j] != 1) continue;
                    if(visited[i][j]) continue;               
                    
                    //도형 모양 diagram 위치 저장해주기
                    List<Node> diagram = viewDiagram(curTable, i, j, 1, visited);
                    //빈공간 찾아서 space 위치 저장하기, diagram과 space 동일한지 체크
                    boolean[][] visited2 = new boolean[N][N];
                    loop: for(int x = 0; x < N; x++) {
                        for(int y = 0; y < N; y++) {
                            
                            if(game_board[x][y] != 0) continue;
                            if(visited2[x][y]) continue;
                            
                            List<Node> space = viewDiagram(game_board, x, y, 0, visited2);
                            
                            boolean check = false;
                            if(diagram.size() == space.size()) {
                                
                                for(int d = 0; d < diagram.size(); d++) {
                                    Node diagramNode = diagram.get(d);
                                    Node spaceNode = space.get(d);

                                    if(diagramNode.r != spaceNode.r) break;
                                    if(diagramNode.c != spaceNode.c) break;
                                    
                                    if(d == diagram.size()-1) check = true;
                                }
                            }
                            
                            //들어갈 수 있으면 game_board와 table에 체크해주기
                            if(check) {
                                // System.out.println(i + " " + j + " " + diagram);
                                // System.out.println(x + " " + y + " " + space);
                                checkVisited(curTable, i, j, diagram);
                                checkVisited(game_board, x, y, space);
                                answer+=space.size();
                                break loop;
                            }
                        }
                    }
                }
            }         
//             System.out.println("--------------처리이후----------------");
//             System.out.println("--------------curTable----------------");
//             for(int[] t : curTable) System.out.println(Arrays.toString(t));
            
//             System.out.println("--------------game_board----------------");
//             for(int[] t : game_board) System.out.println(Arrays.toString(t));
//             System.out.println("--------------------------------------");
            
            rotate(a);
        }
        
        return answer;
    }
    
    int[] nr = {-1, 0, 1, 0};
    int[] nc = {0, 1, 0, -1};
    
    private List<Node> viewDiagram(int[][] curTable, int i, int j, int type, boolean[][] visited) {
        List<Node> list = new ArrayList();
        Queue<Node> q = new LinkedList();
        q.add(new Node(i, j));
        

         while(!q.isEmpty()) {
            Node curN = q.poll();
            if(visited[curN.r][curN.c]) continue;
             visited[curN.r][curN.c] = true;
             list.add(new Node(curN.r - i, curN.c - j));
                
            for(int d = 0; d < 4; d++) {
                int newR = curN.r + nr[d];
                int newC = curN.c + nc[d];
                

                if(newR >= N || newC >= N || newR < 0 || newC < 0) continue;
                if(curTable[newR][newC] != type) continue;
                
                // System.out.println(newR + " " + newC);
                
                q.add(new Node(newR, newC));
            }
        }
        // System.out.println("-----------------------");
        return list;
    }
    
    private void rotate(int angle) {
        int[][] nxtTable;
        int[][] prvTable;
        
        if(angle == 0) {
            nxtTable = table90;
            prvTable = table;
        }
        else if(angle == 1) {
            nxtTable = table180;
            prvTable = table90;
        }
        else {
            nxtTable = table270;
            prvTable = table180;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                nxtTable[j][N-i-1] = prvTable[i][j];
            }
        }
    }
    
    
    private void checkVisited(int[][] curTable, int i, int j, List<Node> list) {
        curTable[i][j] = 2;
        for(int d = 0; d < list.size(); d++) {
            Node cur = list.get(d);
            int newR = i + cur.r;
            int newC = j + cur.c;

            if(newR >= N || newC >= N || newR < 0 || newC < 0) continue;
            
            curTable[newR][newC] = 2;
        }
    }
}