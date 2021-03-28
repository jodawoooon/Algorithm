package boj.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_BJ_11656_접미사배열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			String str = "";
			for (int j = i; j < word.length(); j++) {
				str += word.charAt(j);
			}
			list.add(str);
		}
		
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
