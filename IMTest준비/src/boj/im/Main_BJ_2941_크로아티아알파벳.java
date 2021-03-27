package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_BJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int cnt = 0;
		int size = word.length();

		
		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i)=='c') {
				if(i<size-1&&word.charAt(i+1)=='=') {
					i++;
				}else if(i<size-1&&word.charAt(i+1)=='-') {
					i++;
				}
			}else if(word.charAt(i)=='d') {
				if(i<size-1 && word.charAt(i+1)=='z') {
					if(i<size-2&&word.charAt(i+2)=='=') {
						i += 2;
					}
				}else if(i<size-1&&word.charAt(i+1)=='-') {
					i++;
				}

			}else if(word.charAt(i)=='l') {
				if(i<size-1&&word.charAt(i+1)=='j') {
					i++;
				}
			}else if(word.charAt(i)=='n') {
				if(i<size-1&&word.charAt(i+1)=='j') {
					i++;
				}
			}else if(word.charAt(i)=='s') {
				if(i<size-1&&word.charAt(i+1)=='=') {
					i++;
				}
			}else if(word.charAt(i)=='z') {
				if(i<size-1&&word.charAt(i+1)=='=') {
					i++;
				}
			}
			cnt++;
			
		}System.out.println(cnt);
	}

}
