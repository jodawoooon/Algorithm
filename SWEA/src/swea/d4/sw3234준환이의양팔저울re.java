package swea.d4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class sw3234준환이의양팔저울re {
	/*
	 * N개의 무게추를 양팔저울에 올리는 경우의 수.
	 * 단 오른쪽 무게의 총합이 왼쪽 무게의 총합보다 커지면 안된다.
	 * 
	 * 
	 */
	static int T, N, ans;
	static int[] src;
	static boolean[] select;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("3234input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
        	
        	N = Integer.parseInt(br.readLine()); 
            src = new int[N];
            select = new boolean[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}

            ans = 0;
            perm(0,0,0);
            
 
            System.out.println("#"+t+" "+ans);
        }
    }
	private static void perm(int tgtIdx, int leftSum, int rightSum) {
		if(rightSum>leftSum) return; //가지치기
		
		//기저조건
		if(tgtIdx==N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(select[i])  continue;
			select[i] = true;
			perm(tgtIdx+1,leftSum+src[i],rightSum); //왼쪽 추에 담는다
			perm(tgtIdx+1,leftSum,rightSum+src[i]); //오른쪽 추에 담는다
			select[i] = false;
		}
	}
	
     
}