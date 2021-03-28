package boj.step007문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1316 {
	static int N, ans;
	static boolean[] arr;
	static char[] word;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = N;
		
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			word = new char[str.length()];
			arr = new boolean[26];
		
			boolean check = false;
			
			
			for (int i = 0; i < str.length(); i++) {
				word[i] = str.charAt(i);
			}
			
			for (int i = 0; i < word.length; i++) {
				if(!arr[word[i]-'a']) { //아직 사용하지 않은 알파벳이면
					
					while(true) {
						if(i+1>=word.length) break;
						//System.out.println(word[i] + " "+ word[i+1]);
						if(word[i]!=word[i+1]) { //다음 알파벳이랑 값이 다르면
							
							arr[word[i]-'a']=true;
							break;
						}

						i++;

					}
				}else{
					//System.out.println(word[i] + " "+ word[i+1]);
					check = true;
				}
			}
			if(check) --ans;
			
			
		}
		System.out.println(ans);
	}

}
