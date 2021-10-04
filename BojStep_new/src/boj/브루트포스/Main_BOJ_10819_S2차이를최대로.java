package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10819_S2차이를최대로 {
	static int N, map[], max;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());			
		}

		dfs(0, new boolean[N], new int[N], map); //경우의 수 구하기

		System.out.println(max);
	}

    static void dfs(int cnt, boolean[] visited, int[] arr, int[] v){
        if(cnt==N){ //종료조건
            int sum = 0;
            for(int i = 0 ; i < N-1 ; i++){
                sum += Math.abs(arr[i]-arr[i+1]); //주어진 수식에 맞게
            }
            max = Math.max(sum, max); //sum값이 최대가 되는 경우를 찾는다.
            return;
        }

        for(int i = 0 ; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = v[i];
            dfs(cnt+1, visited, arr, v);
            visited[i] = false;
        }

    }
}
