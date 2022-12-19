import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			int x = Integer.parseInt(input) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			int start = 0;
			int end = n-1;
			boolean flag = true;
			
			while(true) {
				
				if(start>=end) {
					flag = false;
					break;
				}
				
				int sum = arr[start] + arr[end]; 
				
				if(sum > x) {
					end--;
				}else if (sum < x) {
					start++;
				} else {
					break;
				}
				
			}
			if(flag ) {
				System.out.println("yes " + arr[start] + " " + arr[end]);
			} else {
				System.out.println("danger");
			}
		}
	}
}