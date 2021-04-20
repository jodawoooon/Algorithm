package boj.수학;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main_BJ_1708_볼록껍질 {

	static class L{
		long x;
		long y;
		public L(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "L [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static class LC implements Comparator<L>{
		//y좌표가 가장 작은 점부터 정렬하는 comparator
		
		@Override
		public int compare(L p1, L p2) {
			int re=Long.compare(p1.y, p2.y); //y를 기준으로 오름차순 정렬
			if(re==0) { //y좌표가 같다면
				return Long.compare(p1.x, p2.x); //x좌표를 기준으로 오름차순 정렬
			}else {
				return re;
			}
		}
		
	}
	
	static class LTC implements Comparator<L>{
		//오른쪽에 있는 점을 먼저 오도록 정렬 => 반시계 방향으로 점의 인덱스가 증가함
		
		L p0;
		public LTC(L p0) {
			this.p0 = p0;
		}

		@Override 
		public int compare(L p1, L p2) { 
			int re=ccw(p0,p1,p2);
			if(re==0) {
				long distance1 = dist(p0, p1);
                long distance2 = dist(p0, p2);

                if (distance1 > distance2) {    // 거리가 더 가까운 순으로 정렬
                    return 1;
                }else return -1;
			}else {
				return re>0 ? -1:1;// 앞에가 크면 뒤집어 -> ASC 각도순으로 첫 좌표에서
			}
		}
		
	}
	static int N;
	public static void main(String[] args) {
		
		
		/*
		 * 알고리즘
		 * 1. 점들 중 y좌표가 제일 작고, y좌표가 같다면 x좌표가 가장 작은것을 기준점으로 잡는다.
		 * 	(나머지 모든 점이 이 점을 기준으로 한 쪽에 모여있어야 한다)
		 * 2. 기준점을 기준으로 다른 점들을 반시계 방향으로 각에 따라 정렬한다.
		 * 3. Stack에 p0, p1를 넣는다.
		 *
		 * 4. 점들을 하나씩 보면서 볼록 껍질에 포함시킬지 말지를 결정한다.
		 * 		1. first, second, next 세 값으로 CCW 인지 판별한다.
		 * 		2. CCW 면 next를 Stack에 넣고, CCW가 아니면 second를 빼고 CCW 인지 다시 확인한다.
		 * 		3. 주어진 점의 개수만큼 4~5번을 반복한다.
		 */
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt(); //점의 개수 N
		
		ArrayList<L> points=new ArrayList<>(); //각 점의 좌표를 저장할 arrayList
		Stack<L> hull=new Stack<>(); 
		
		
		for (int i = 0; i < N; i++) {
			long x=scann.nextLong(); //각 점의 x,y좌표를 입력받는다.
			long y=scann.nextLong();
			points.add(new L(x,y)); //points 리스트에 좌표 저장
		}
		
		points.sort(new LC());  //y좌표를 기준으로 작은것부터 정렬 (y좌표가 같다면 x좌표가 작은것부터 정렬)
		
		L p0=points.remove(0); //0번점 p0 : 점들 중 y좌표가 제일 작고, y좌표가 같다면 x좌표가 가장 작은것을 기준점으로 잡는다.
		hull.push(p0); //0번점을 스택에 넣는다
		
		points.sort(new LTC(p0)); //기준점을 제외한 나머지 점들을, 기준점 (p0)에 대해 정렬한다.
		//오른쪽에 있는 점을 먼저 오도록 정렬 => 반시계 방향으로 점의 인덱스가 증가함
		
		L p1=points.remove(0); //1번점 p1
		hull.push(p1); //1번점을 스택에 넣는다
		
		for (int i = 0; i < N-2; i++) { //남은 점들을 확인한다
			
			
			L next =points.get(i); //next 점
			
			while(hull.size()>=2) {// 두개이상이면 비교를 한다.
				L first=hull.pop();   //위의것이 뒤에 들어간것. (0번점)
				L second=hull.peek();  //먼저 들어간것 (1번점)
				
				int ccwvalue=ccw(second, first, next); //next가  기준벡터보다 왼쪽에 있는지(반시계방향인지) 오른쪽에 있는지(시계방향인지 ) 체크
				if(ccwvalue>0) { //왼쪽에 있으면(반시계방향에 있으면) 만족하므로 스택에 넣는다
					hull.push(first);  //스택에 넣는다
					break;
				} //시계방향이면 만족하지 않으므로 다시 push하지 않는다(pop함)
			}
			
			hull.push(next); //스택에 next를 넣는다.
		}
		//모든 점을 확인하면 반복문 종료
		//hull 스택에 남아있는 점들이 반시계 방향으로 볼록껍질을 이루게 된다
		
		
		System.out.println(hull.size()); //점들의 개수

	}

	static int ccw(L p, L a, L b) {
		//선분 pa, pc가 만드는 각이 양수인지 음수인지 return한다
		
		long result =cross(vec(p,a),vec(a,b));
    	if (result > 0) {   // 반시계 방향
            return 1;
        } else if (result < 0) {    // 시계 방향
            return -1;
        } else {
            return 0;
        }
	}
	
	static long cross(L a, L b) {
		return a.x*b.y-a.y*b.x;
	}
	
	//ab-> ob-oa 상대벡터
	static L vec(L a, L b) {
		long x=b.x-a.x;
		long y=b.y-a.y;
		return new L(x,y);
	}
	
	
	static long dist(L p1, L p2) {
		//두 점 p1, p2 사이의 거리를 구하는 메소드
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
	
}
