package level1;

import java.util.*;

public class Solution_직사각형별찍기 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String ans = "";
        String str= "";
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = 0; i < a; i++) {
			str += "*";
		}
        for (int i = 0; i < b; i++) {
			ans += str;
			if(i!=(b-1)) ans+="\n";
		}
        System.out.println(ans);
    }

}