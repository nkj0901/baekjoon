import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		c = new char[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			c[i] = st.nextToken().charAt(0);
		}

		sel = new char[L];
		check = new boolean[C];
		ans = new ArrayList<String>();
		Arrays.sort(c);

		select(0, 0);

		for (int i = 0; i < ans.size(); i++) {
			bw.write(ans.get(i));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();

	}

	static BufferedWriter bw;
	static int L, C;
	static char[] sel;
	static boolean[] check;
	static char[] c;
	static List<String> ans;

	private static void select(int idx, int sidx) throws IOException {

		if (sidx == L) {

			for (int i = 1; i < L; i++) {
				if (sel[i - 1] > sel[i])
					return;
			}
			
			int m = 0, j = 0;
			for (int i = 0; i < L; i++) {
				if (sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' || sel[i] == 'o' || sel[i] == 'u') {
					m++;
				} else {
					j++;
				}
			}

			if (m < 1 || j < 2)
				return;

			ans.add(new String(sel));
			return;
		}
		
		if (idx == C)
			return;
		
		sel[sidx] = c[idx];
		select(idx+1, sidx+1);
		select(idx+1, sidx);		
	}
}