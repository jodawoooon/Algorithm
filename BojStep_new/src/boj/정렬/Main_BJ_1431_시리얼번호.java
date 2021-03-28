package boj.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_BJ_1431_시리얼번호 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length()) {
					return o1.length()-o2.length();
				}else if(o1.length()==o2.length()) {
					int sum1 = 0;
					int sum2 = 0;
					for (int i = 0; i < o1.length(); i++) {
						if(o1.charAt(i)-'0'<=9) {
							sum1+=o1.charAt(i)-'0';
						}
						
						if(o2.charAt(i)-'0'<=9) {
							sum2+=o2.charAt(i)-'0';
						}
					}
					if(sum1!=sum2) return sum1 - sum2;
				}
				return o1.compareTo(o2);
				
			}
			
		});
	
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
