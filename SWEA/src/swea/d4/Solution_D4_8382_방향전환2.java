package swea.d4;
import java.util.Scanner;

public class Solution_D4_8382_방향전환2 {
	static int T;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt(); //tc 갯수
		
		
		for (int i = 1; i <= T; i++) {
			
			int x1=scann.nextInt(); //출발지 x값
			int y1=scann.nextInt(); //출발지 y값
			int x2=scann.nextInt(); //도착지 x값
			int y2=scann.nextInt(); //도착지 y값
			//출발지, 도착지 변수 셋팅
			
			
			int X=Math.abs(x2-x1);
			int Y=Math.abs(y2-y1);
			//X는 두 점의 x좌표 거리, Y는 두 점의 y좌표 거리이다
			
			int t=(X+Y)/2; 
			//t는 대각선 (y=x)그래프를 방문할 때의 위치 번호이다.
			
			int val=Math.abs(t-X)+Math.abs(t-Y)+2*t;
			//value = t에서 벗어난 거리 + 2t이다.
			
			System.out.println("#"+i+" "+val);
		
		}
	}
}
