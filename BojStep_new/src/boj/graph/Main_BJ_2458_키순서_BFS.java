package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2458_키순서_BFS {
	
	static ArrayList<Integer>[] winList, loseList;
	static int N, M, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		winList = new ArrayList[N+1]; //1~n번  선수가 이긴 선수 리스트
        loseList = new ArrayList[N+1]; //1~n번 선수가 진 선수 리스트
        
        for (int i = 0; i <= N; i++) {
			winList[i] = new ArrayList<>();
			loseList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			winList[A].add(B); //A가 B보다 크다.
			loseList[B].add(A); //B가 A보다 작다.
		}
		
		for (int idx = 1; idx <= N; idx++) {
        	int winCnt = getWinCnt(idx, N);
        	int loseCnt = getLoseCnt(idx, N);

        	if(winCnt + loseCnt == N-1) answer++; 
            //이긴선수 + 진 선수 = n-1이면 모든 경기의 결과를 알수 있으므로 등수를 구할 수 있다.
		}
		
		
		System.out.println(answer);
	}
	
	//idx 선수가 이긴 선수의 수를 구하는 bfs 메소드
		private static int getWinCnt(int idx,int n) {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[n+1];
			int winCnt = 0;
			
			queue.add(idx);
			visited[idx]=true;
			
			while(!queue.isEmpty()) {
				int playerNum = queue.poll();
				
				for (int i = 0; i < winList[playerNum].size(); i++) {
					int tgtNum = winList[playerNum].get(i);
					if(visited[tgtNum]) continue;
					visited[tgtNum] = true;
					queue.add(tgtNum);
					winCnt++;
				}
			}
			return winCnt;
		}
		
	    //idx 선수가 진 선수의 수를 구하는 bfs 메소드
		private static int getLoseCnt(int idx,int n) {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[n+1];
			int loseCnt = 0;
			
			queue.add(idx);
			visited[idx]=true;
			
			while(!queue.isEmpty()) {
				int playerNum = queue.poll();
				
				for (int i = 0; i < loseList[playerNum].size(); i++) {
					int tgtNum = loseList[playerNum].get(i);
					if(visited[tgtNum]) continue;
					visited[tgtNum] = true;
					queue.add(tgtNum);
					loseCnt++;
				}
			}
			return loseCnt;
		}
}
