import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Meat {
        int gram;
        int price;

        Meat(int gram, int price) {
            this.gram = gram;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Meat> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Meat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort((Meat m1, Meat m2) -> {
            if(m1.price > m2.price) return -1;
            else if(m1.price < m2.price) return 1;
            else return m1.gram-m2.gram;
        });

        int gram = 0;
        int price = 0;
        int sumPrice = 0;
        boolean check = false;

        //뒤에서부터 보면서 최저 가격을 찾아라
        for(int i = N-1; i >= 0; i--) {
            gram += list.get(i).gram;

            if(list.get(i).price > price) {
                if (check) {
                    sumPrice = price = Math.min(list.get(i).price, sumPrice);
                    break;
                } else sumPrice = price = list.get(i).price;
            }
            else if(!check) {
                sumPrice += list.get(i).price;
                price = list.get(i).price;
            }
            if(gram >= M) {
                check = true;
            }
        }
        if(check) System.out.println(sumPrice);
        else System.out.println(-1);
    }
}