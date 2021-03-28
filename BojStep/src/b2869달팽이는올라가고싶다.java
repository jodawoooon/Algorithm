import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2869달팽이는올라가고싶다 {
	static int A, B, V, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
//		거 = 속*시
//		V = (A-B)*t+B
		if((V-B)%(A-B)==0) {
			ans = (V-B)/(A-B);
		}else {
			ans = (V-B)/(A-B)+1;
		}
		
		System.out.println(ans);
	}
}
