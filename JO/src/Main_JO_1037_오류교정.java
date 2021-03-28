
import java.util.Arrays;
import java.util.Scanner;

public class Main_JO_1037_오류교정 {
	
	static boolean[][] check;

	static int N;
	static int[] sum1, sum2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		check = new boolean[N][N];
		sum1 = new int[N];
		sum2 = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(sc.nextInt()==0) {
					check[i][j] = false;
				}else {
					check[i][j] = true;
				}
			}
		}
		
		
		//패리티 성질을 가지고 있는지 판단. 각 열과 행이 짝수 합을 가질때
		
		int tmpI = 0;
		int cnt1 = 0;
		int tmpJ = 0;
		int cnt2 = 0;
		
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < N; j++) {
				if(check[i][j]) {
					sum1[i]++;
				}

				
			}
			if(sum1[i]%2==1) {
				cnt1++;
				tmpI = i;
			}
		}
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < N; j++) {
				if(check[j][i]) {
					sum2[i]++;
				}

				
			}
			if(sum2[i]%2==1) {
				cnt2++;
				tmpJ = i;
			}
		}

		if(cnt1==0&&cnt2==0) {
			System.out.println("OK");
		}else if(cnt1==1&&cnt2==1) {
			System.out.println("Change bit ("+(tmpI+1)+","+(tmpJ+1)+")");
		}else {
			System.out.println("Corrupt");
		}

	}
}
