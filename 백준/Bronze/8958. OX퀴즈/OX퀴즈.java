import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<t; i++) {
			
			String oxox = br.readLine();
			//받은 문자열을 chararray로 바꾸기
			char[] sp = oxox.toCharArray();
			
			//ox인지 판별하기 배열 길이만큼 돌리기
			int a = 0;
			int o = 0;//누적 개수를 저장
			int ans = 0; //합산 값을 저장
			while(sp.length>a) {
				if(sp[a] == 'O') {
					o+=1;
					ans+=o;
				} else {
					o = 0;
				}
				a++;
			}
			System.out.println(ans);
			}
	}
}