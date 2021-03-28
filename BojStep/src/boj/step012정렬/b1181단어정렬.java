package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class b1181단어정렬 {
	static int N,ans;
	
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		//알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
		//길이가 짧은 것부터
		//길이가 같으면 사전 순으로
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()!=s2.length()) {
					return s1.length()-s2.length();
				}else {
					int size = Math.min(s1.length(), s2.length());
					int tmp = 0;
					for (int i = 0; i < size; i++) {
						if(s1.charAt(i)==s2.charAt(i)) continue;
						else {
							tmp = s1.charAt(i)-s2.charAt(i);
							break;
						}
					}
					return tmp;
					
				}
			}
		});
		
		ArrayList<String> list = new ArrayList<>();
		
		for (String str : arr) {
			if(!list.contains(str)) {
				list.add(str);
			}
		}
		
		for (String str : list) {
			bw.write(str+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
		
}
