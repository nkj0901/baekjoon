import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int l_minute = (video_len.charAt(0) - '0') * 10 + (video_len.charAt(1) - '0');
        int l_second = (video_len.charAt(3) - '0') * 10 + (video_len.charAt(4) - '0');
        
        int p_minute = (pos.charAt(0) - '0') * 10 + (pos.charAt(1) - '0');
        int p_second = (pos.charAt(3) - '0') * 10 + (pos.charAt(4) - '0');
        
        int s_minute = (op_start.charAt(0) - '0') * 10 + (op_start.charAt(1) - '0');
        int s_second = (op_start.charAt(3) - '0') * 10 + (op_start.charAt(4) - '0');
        
        int e_minute = (op_end.charAt(0) - '0') * 10 + (op_end.charAt(1) - '0');
        int e_second = (op_end.charAt(3) - '0') * 10 + (op_end.charAt(4) - '0');
        
        if(isOpening(p_minute, p_second, s_minute, s_second, e_minute, e_second)) {
            p_minute = e_minute;
            p_second = e_second;
        }
        
        for(int i = 0; i < commands.length; i++) {
            
            if(commands[i].equals("next")) {
                if(p_second + 10 >= 60) p_minute++; 
                p_second = (p_second + 10) % 60;     
                
                if(p_minute >= l_minute && p_second > l_second) {
                    p_minute = l_minute;
                    p_second = l_second;
                }
            } else {
                if(p_second - 10 < 0) {
                    p_minute--;
                    p_second = p_second - 10 + 60;
                } else p_second = p_second - 10;
                
                if(p_minute < 0) {
                    p_minute = 0;
                    p_second = 0;
                }
            }
            
            if(isOpening(p_minute, p_second, s_minute, s_second, e_minute, e_second)) {
                p_minute = e_minute;
                p_second = e_second;
            }
        }
        
        // System.out.println(p_minute + ":" + p_second);
        if(p_minute < 10) answer +="0";
        answer+= p_minute + ":";
        if(p_second < 10) answer+= "0";
        answer+= p_second;
        
        return answer;
    }
    
    private boolean isOpening(int p_minute, int p_second, int s_minute, int s_second, int e_minute, int e_second) {
        
        if((p_minute > s_minute || (p_minute == s_minute && p_second >= s_second)) 
           && (p_minute < e_minute || ( p_minute == e_minute && p_second < e_second))) {
            return true;
        }
        return false;
    }
}