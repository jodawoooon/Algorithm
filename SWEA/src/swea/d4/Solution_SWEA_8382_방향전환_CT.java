package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_8382_방향전환_CT {
	


	static int x1,x2,y1,y2,ans;

	static boolean visited[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine()," ");
	    int T = Integer.parseInt(st.nextToken());
	    
	    
	    for (int t = 1; t <= T; t++) {
	    	ans = 0;
	    	
	    	st = new StringTokenizer(br.readLine()," ");
	        x1 = Integer.parseInt(st.nextToken());
	        y1 = Integer.parseInt(st.nextToken());
	        x2 = Integer.parseInt(st.nextToken());
	        y2 = Integer.parseInt(st.nextToken());
	       
	        
	        //이 때, 최소 몇 번의 이동을 해야 
	    	//(x1, y1)에서 (x2, y2)로 이동할 수 있는지 구하는 프로그램을 작성하라.
	        
	    	int x_dis = Math.abs(x2-x1);
	    	int y_dis = Math.abs(y2-y1);
	    	
	    	
	    	int min= Math.min(x_dis,y_dis);
            
	    	ans = min*2;
	    	
	    	if(x_dis!=y_dis) {
	    		int tmp = x_dis - min + y_dis - min;
	    		
	    		if(tmp%2==0) ans += 2*tmp;
	    		else ans += 2*tmp -1;
	    	}
	    	
            System.out.println("#"+t+" "+ans);
		}
	}
	
	   
}
