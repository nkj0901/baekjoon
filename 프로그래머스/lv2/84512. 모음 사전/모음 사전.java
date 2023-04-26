import java.util.*;

class Solution {
    public int solution(String word) {
        c = new String[] {"A", "E", "I", "O", "U"};
        cnt = 0;
        check = false;
        combination(0, "", word);        
        return cnt;
    }
    
    static String[] c;
    static int cnt;
    static boolean check;

    public void combination(int idx, String str, String word){

        if(idx == 5) return;

        for(int i = 0; i < 5; i++){
            if(check) return;
            str+=c[i];
            cnt++;

            if(str.equals(word)) {
                check = true;
                return;
            }
            combination(idx+1, str, word);
            str = str.substring(0, idx);
            
        }
    }
}

