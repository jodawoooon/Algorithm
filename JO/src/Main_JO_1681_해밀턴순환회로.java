import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {
	static int N, arr[][], ans;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		visited[0] = true;
		ans = Integer.MAX_VALUE;
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		
		//0번~4번->0번
		
		dfs(0,0,0);
		System.out.println(ans);
		//0부터 4까지 다 들리는 경우를 구하고
		//집으로 돌아가는길은 +arr[end][0]
	}
	private static void dfs(int current, int idx, int sum) {
		if(sum>ans) return; //가지치기 안하면 시간초과남
		if(idx==N-1) {
			//집으로 돌아가는길은 +arr[end][0]
			sum += arr[current][0];
			if(arr[current][0]==0) return;
			
			ans = Math.min(sum, ans);
			return;
		}
		
		//0부터 4까지 다 들리는 경우를 구하고 : 순열
		for (int i = 0; i < N; i++) {
			if(!visited[i]&&arr[current][i]!=0) {
				visited[i] = true;
				dfs(i, idx+1, sum+arr[current][i]);
				visited[i] = false;
			}
		}
	}
}
