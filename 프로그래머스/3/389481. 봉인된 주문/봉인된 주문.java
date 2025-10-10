import java.util.*;
import java.io.*;
    
class Solution {
    long[] range;
    long[] cnt;
    
    public String solution(long n, String[] bans) {
        String answer = "";
        
        //앞에 있는 애들 몇개인지 보기
        Arrays.sort(bans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else return o1.length() - o2.length();
            }
        });
        
        for(int i = 0; i < bans.length; i++) {
            //ban 안에 것들 숫자로 만들어서 비교하기
            if(getLong(bans[i]) <= n) n++;
        }
        
        // System.out.println(n);
        
        return getString(n);
    }
    
    private long getLong(String str) {
        // System.out.println("getLong str " + str); 
        long num = 0;
        for(int i = 0; i < str.length(); i++) {
            long value = str.charAt(i) - 'a' + 1;
            num = num * 26 + value;
            // System.out.println("getLong num " + num); 
        }
        
        return num;
    }
    
    private String getString(long n) {
        
        StringBuilder sb = new StringBuilder();
        
        while(n-- > 0) {
            char c = (char) (n%26 + 'a');
            sb.append(c);
            n/=26;            
        }
        
        return sb.reverse().toString();
    }
}