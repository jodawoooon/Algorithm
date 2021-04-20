package swea.d4;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D4_8458_원점으로집합 {

	static int T,N;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt(); //tc 개수
		
		
		//i번째 움직임에서 각 점은 상하좌우로 i만큼의 거리를 반드시 이동해야 한다.
		//최소 몇 번의 움직임으로 모든 점을 원점에 모을 수 있는지 구하는 프로그램을 작성하라.
		
		for (int t = 1; t <= T; t++) {
			
			N=scann.nextInt(); //좌표개수
			
			ArrayList<Integer> points=new ArrayList<>();
			//각 좌표의 원점으로부터의 거리를 저장할 arraylist
			
			for (int i = 0; i < N; i++) {
				int x=scann.nextInt();
				int y=scann.nextInt();
				points.add(Math.abs(x)+Math.abs(y)); //길이
			}
			//각 x,y좌표의 원점으로부터의 거리를 points list에 넣어둔다.
			
			
			//모든 점의 원점으로부터의 거리가 짝수이거나 홀수여야 한다. 
			//이 외에는 전부 원점으로 이동할 수 없다.
			
			
			int max=-1;
			//만약 모든 점을 원점으로 이동시킬 수 없으면, -1을 출력한다.
			
			for (int i = 0; i < N; i++) {
				max=Math.max(max, points.get(i));
			}
			//거리값 중 max값을 찾는다. (가장 멀리 이동해야하는거리)
			
			if(max==0) {
				System.out.println("#"+t+" "+0);
			}
			//원점과의 거리의 max가 0이면, 모두 0이라는 뜻이다.
			//이동할 필요가 없으므로 0을 출력한다.
			
			else if(!isAll(points)) {
				System.out.println("#"+t+" "+(-1));
			}
			//모든 점의 원점으로부터의 거리가 짝수이거나 홀수가 아니면 -1 출력.
			
			else if(isAllEven(points)) {
				//모든 점의 원점으로부터의 거리가 짝수라면
				
				int tt=val(max);			
				//t에 따라 가질 수 있는 가장 큰 값 (max거리의 군)
				
				for (int i = tt; i < 63248; i++) {
					//맥시멈 범위만큼 for문을 돌면서
					//t를 이동시킨다
					long ss=nth(i);
					//i가 몇번째인지
					if(ss%2==0) { 
						//짝수까지 왔다면 그때의 i값 출력
						tt=i;
						break;
					}
				}
				
				System.out.println("#"+t+" "+(tt));
			}
			
			
			else if(isAllOdd(points)) {
				//모든 점의 원점으로부터의 거리가 홀수라면
				
				int tt=val(max);
				//t에 따라 가질 수 있는 가장 큰 값 (max거리의 군)
				
				for (int i = tt; i < 63248; i++) {
					//맥시멈 범위만큼 for문을 돌면서
					//t를 이동시킨다
					long ss=nth(i);
					//i가 몇번째인지 
					if(ss%2==1) {
						//홀수까지 왔다면 그때의 i값 출력
						tt=i;
						break;
					}
				
				}
				System.out.println("#"+t+" "+(tt));
			}
		}
	}
	
	
	//모든 점의 거리가 홀수인지 체크하는 함수
	static boolean isAllOdd(ArrayList<Integer> points) {
		for (int i = 0; i < points.size(); i++) {
			if(points.get(i)%2==0) {//하나라도 짝수라면 false
				return false;
			}
		}
		return true;
	}
	
	//모든 점의 거리가 짝수인지 체크하는 함수
	static boolean isAllEven(ArrayList<Integer> points) {
		for (int i = 0; i < points.size(); i++) {
			if(points.get(i)%2!=0) {//하나라도 홀수라면 false
				return false;
			}
		}
		return true;
	}
	
	//모든 점의 거리가 짝수 이거나 홀수 인지 확인하는 함수
	static boolean isAll(ArrayList<Integer> points) {
		boolean isS=false;
		if(isAllEven(points) || isAllOdd(points)) {
			isS=true; //모두 짝수이거나, 모두 홀수이면 true
		}else {
			isS=false; //아니면 false
		}
		return isS;
	}
	
	static int val(int t) {
		
		
		double x= (-1.0 + Math.sqrt(1.0+8.0*t))/2.0;
		//공식
		return (int)Math.ceil(x); //x보다 같거나 큰 정수를 구하므로 ceil
	}
	
	static long nth(int n) {
		return 0L+n*(n+1L)/2L; // n(n+1)/2
	}
	
}
