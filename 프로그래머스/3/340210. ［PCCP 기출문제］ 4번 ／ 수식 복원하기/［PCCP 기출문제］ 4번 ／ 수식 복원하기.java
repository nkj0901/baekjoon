import java.util.*;
import java.io.*;

class Solution {
    int maxInt;
    
    public String[] solution(String[] expressions) {
        List<int[]> list = new ArrayList<>();
        
        maxInt = -1;
        int jinsu = 0;
        
        //일단 expressions 보면서 판단할 수 있는지 보기
        //만약 판단을 못했을 때를 대비하여 자리수 max 값 구하기
        StringTokenizer st;
        for(int i = 0; i < expressions.length; i++) {
            
            String str = expressions[i];
            st = new StringTokenizer(str);
            
            int a = Integer.parseInt(st.nextToken());
            String sign = st.nextToken();
            
            int b = Integer.parseInt(st.nextToken());
            String sign2 = st.nextToken();
            
            String tmp = st.nextToken();
            // C가 X이면 따로 list에 넣어주기
            if(tmp.equals("X")) {
                
                int[] arr = new int[3];
                arr[0] = a;
                arr[1] = sign.equals("+") ? 1 : 0;
                arr[2] = b;
                list.add(arr);
                
            } else {
                
                int c = Integer.parseInt(tmp);
                getMaxInt(c);
                
                int a1 = a % 10;
                int a2 = a / 10;
                int b1 = b % 10;
                int b2 = b / 10;
                int c1 = c % 10;
                int c2 = c / 10 % 10;
                int c3 = c / 100;
                
                // System.out.println(a1 + " " + a2 + " " + b1 + " " + b2 + " " + c1 + " " + c2 + " " + c3);
                            
                // 답이 나와있을 때 a b 계산해서 판단해보기
                if(sign.equals("+")) {
                    //올림 발생
                    if(a1 + b1 != c1) {
                        jinsu = a1 + b1 - c1;
                        a2++;
                    } else if(a2 + b2 != c2) {
                        jinsu = a2 + b2 - c2;
                    }
                }
                //마이너스일 때
                else {
                    //내림 발생
                    if(a1 - b1 != c1) {
                        jinsu = Math.abs(a1 - b1) + c1;
                        a2--;
                    } else if(a2 - b2 != c2) {
                        jinsu = Math.abs(a2 - b2) + c2;
                    }
                }
            }
           
            //각 자리수 판단하기
            getMaxInt(a);
            getMaxInt(b);
        }
        
        // System.out.println(jinsu);
        // System.out.println(maxInt);
        if(maxInt == 8) jinsu = 9;
        
        String[] answer = new String[list.size()];
        //만약 진수가 판단되지 않았으면 maxInt 값으로 판단해주기
        if(jinsu == 0) {
            maxInt++;
            // System.out.println(maxInt);
            for(int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);
                
                //maxInt 값을 넘어가는지 확인 다 넘어가지 않으면 답 넣어주고 하나라도 넘어가면 ?
                int a1 = arr[0] % 10;
                int a2 = arr[0] / 10;
                int b1 = arr[2] % 10;
                int b2 = arr[2] / 10;
                int c = 0;

                //플러스일 때
                if(arr[1] == 1) {
                    if(a1 + b1 < maxInt && a2 + b2 < maxInt) c = a1 + b1 + (a2 + b2) * 10;
                    else c = -1;
                }
                //마이너스일 때
                else {
                    if(a1 - b1 >= 0 && a2 - b2 >= 0) c = a1 - b1 + (a2 - b2) * 10;
                    else c = -1;
                }

                answer[i] = arr[0] + (arr[1] == 1 ? " + " : " - ") + arr[2] + " = " + (c == -1 ? "?" : c + "");
            }
        }
        //진수가 판단되었으면 진수 적용해서 계산
        else {
             for(int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);
                // System.out.println(Arrays.toString(arr));
                
                int a1 = arr[0] % 10;
                int a2 = arr[0] / 10;
                int b1 = arr[2] % 10;
                int b2 = arr[2] / 10;
                int c = 0;
                
                //+이면
                if(arr[1] == 1) {
                    
                    //일의 자리
                    if(a1 + b1 >= jinsu) {
                        a2++;
                        c+= a1 + b1 - jinsu;
                    } else {
                        c+= a1 + b1;
                    }
                    
                    //십의 자리
                    if(a2 + b2 >= jinsu) {
                        c+=(a2 + b2 - jinsu) * 10 + 100;
                    } else {
                        c+=(a2 + b2) * 10;
                    }
                } 
                //마이너스이면
                else {
                    //일의 자리
                    if(a1 - b1 < 0) {
                        a2--;
                        c+= a1 - b1 + jinsu;
                    } else {
                        c+= a1 - b1;
                    }
                    
                    //십의 자리
                    c+= (a2 - b2) * 10;

                }
                 
                answer[i] = arr[0] + (arr[1] == 1 ? " + " : " - ") + arr[2] + " = " + c + "";
            }

        }
        return answer;
    }
    
    private void getMaxInt(int number) {
        int number1 = number % 10;
        int number2 = number / 10 % 10;
        
        maxInt = Math.max(number1, maxInt);
        maxInt = Math.max(number2, maxInt);
    }
}