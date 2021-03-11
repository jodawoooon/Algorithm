package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location2{
	int x;
	int y;
	public Location2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main_BJ_9205_맥주마시면서걸어가기 {
	
	//맥주 1박스 : 맥주 20개
	//50미터에 한병
	//편의점에서 빈병 버리고 새 맥주병 구입 가능
	//단 박스의 맥주는 20병을 넘을 수 없다
	
	//각 테스트 케이스에 대해서 상근이와 친구들이 행복하게 페스티벌에 갈 수 있으면 "happy", 
	//중간에 맥주가 바닥나면 "sad"를 출력한다. 

	static int T,N, bear;
	static Location2 arr[], start, end;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			N = Integer.parseInt(br.readLine()); //맥주 편의점 개수
			arr = new Location2[N+2];
			
			visited = new boolean[N+2];
			
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				arr[i] = new Location2(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
				//System.out.println(arr[i].x+" "+arr[i].y);
				if(i==0) start = arr[i];
				if(i==N+1) end = arr[i];
			}
			
			
			
			bfs(start);
			
		}
	}
	
	private static void bfs(Location2 v) {
		 Queue<Location2> queue = new LinkedList<>();
		 queue.add(v);
		 
		 while(true) {
			 if(queue.isEmpty()) break;
			 
			 Location2 l = queue.poll();
			 
			 if(l.equals(end)) {
				 System.out.println("happy");
				 return;
			 }
			 
			 int x = l.x;
			 int y = l.y;
			 
			 for (int i = 1; i < N+2; i++) {
				if(!visited[i]) {
					
					int nx = arr[i].x;
					int ny = arr[i].y;
					if(Math.abs(x-nx)+Math.abs(y-ny)<=1000) {
						//다음 장소까지의 거리가 50*20 이하
						visited[i] = true;
						queue.add(arr[i]);
						
					}
					
				}
			}
			 
			
		 }
		 System.out.println("sad");
		 return;
	}
}
