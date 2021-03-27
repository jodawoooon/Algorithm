package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1234_비밀번호 {
	
	static int N;
	static char arr[];

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1234input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		for (int t = 1; t <= 10; t++) {
			N=sc.nextInt();
			int ans =0;

			List<Character> list = new ArrayList<>();
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if(i==0||list.isEmpty()) {
					list.add(c);
					continue;
				}
				if(i!=0&&list.size()>=1&&list.contains(c)&&list.get(list.size()-1)==c) {
					list.remove(list.size()-1);
				}else {
					list.add(c);
				}
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}

			System.out.println();
		}
	}
}
