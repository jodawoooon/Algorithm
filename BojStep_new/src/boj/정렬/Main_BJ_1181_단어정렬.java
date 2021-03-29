package boj.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_BJ_1181_단어정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(!list.contains(str)) {
				list.add(str);
			}
			
		}
		
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length()){
					return o1.length() - o2.length();
				}
				return o1.compareTo(o2);
				
		
			}
			
		});
		
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
