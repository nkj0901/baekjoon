import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        Set<Node> set = new HashSet();
        
        int r = 0;
        int c = 0;
        
        int[] dr = {-1, -1 , 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        
        for(int i : arrows) {
            set.add(new Node(r, c, i));
            
            r += dr[i];
            c += dc[i];
            
            boolean isMeet = false;
            for(int j = 0; j < 8; j++) {
                //원래 있던 선...
                if(j == i) {
                    if(set.contains(new Node(r, c, (j + 4) % 8))) {
                        isMeet = false;
                        break;
                    }
                }
                //았으면 꼭지점끼리 만난거임
                isMeet |= set.contains(new Node(r, c, j));
            }
            
            if(isMeet) {
                answer++;
            }
            
            set.add(new Node(r, c, i));
            set.add(new Node(r, c, (i + 4) % 8));
            r += dr[i];
            c += dc[i];
            
            isMeet = false;
            for(int j = 0; j < 8; j++) {
                if(j == i) {
                    if(set.contains(new Node(r, c, (j + 4)%8))) {
                        isMeet = false;
                        break;
                    } 
                }
                isMeet |= set.contains(new Node(r, c, j));
            }
            
            if(isMeet) {
                answer++;
            }
            
            set.add(new Node(r, c, (i+4) % 8));
        }
        return answer;
    }
    
    class Node{
        int r, c, dir;
        
        Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
        
        @Override
        public int hashCode() {
            return r * 1000000 + c * 10 + dir;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node) {
                Node other = (Node) obj;
                if(this.r == other.r && this.c == other.c && this.dir == other.dir) return true;
            }
            return false;
        }
        
    }
}

