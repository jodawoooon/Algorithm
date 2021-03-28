package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b15650_N과M2 {
	static int N, M, COUNT;
	static int[] src;
	static Stack<Integer> tgt;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N+1];
		tgt= new Stack<>();
		isSelected = new boolean[N+1];
		for (int n = 1; n <= N; n++) {
			src[n] = n;
		}
		
		perm(0);
		
	}

	private static void perm(int i) {
		//기저조건
		
		if(i==M) {
			System.out.println(sb);
			return;
		}
		
		for (int j = 1; j <= N; j++) {
			if(isSelected[j]) continue;
			
			if(tgt.isEmpty()) {
				tgt.push(j);
				//System.out.println(tgt.peek());
			}
			
			else if(!tgt.isEmpty()&&tgt.peek()<j) {
			tgt.push(j);
			sb.append(j).append(" ");
			isSelected[j] = true;
			perm(i+1);
			tgt.clear();
			sb.setLength(0);
			isSelected[j] = false;
			}
		}
		
		
	}
}
