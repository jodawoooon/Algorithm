package level1;
import java.util.*;

class Solution_키패드누르기_Kakao {
    static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans, map[][];
    public String solution(int[] numbers, String hand) {
        String ans = "";
		map = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-2}};
		
		int currentL = -1;
		int currentR = -2;
		for (int i = 0; i < numbers.length; i++) {
			
			if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
				ans += "L";
				currentL = numbers[i];
			}else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
				ans += "R";
				currentR = numbers[i];
			}else {
				int minL = 0;
				int minR = 0;
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < 3; k++) {
						if(map[j][k]==currentL) {
							minL = bfs(j,k,currentL,numbers[i]);
						}
						if(map[j][k]==currentR) {
							minR = bfs(j,k,currentR,numbers[i]);
						}
					}
				}
				

				if(minL==minR) {
					if(hand.equals("right")) { //오른손잡이
						ans += "R";
						currentR = numbers[i];
					}else { //왼손잡이
						ans += "L";
						currentL = numbers[i];
					}
				}else {
					if(minR<minL) { 
						ans += "R";
						currentR = numbers[i];
					}else { 
						ans += "L";
						currentL = numbers[i];
					}
				}
			}

		}
        
        return ans;
    }
    
    private static int bfs(int i, int j, int current, int tgt) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[4][3];
		
		q.add(new Node(i,j,0));
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			int cnt= n.cnt;
			if(map[x][y]==tgt) return cnt;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(isIn(nx,ny)&&!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Node(nx,ny,cnt+1));
				}
			}
		}
		
		return -1;
		
	}
	private static boolean isIn(int nx, int ny) {
		if(nx<0||ny<0||nx>=4||ny>=3) return false;
		return true;
	}
	static class Node {
		int x,y,cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}