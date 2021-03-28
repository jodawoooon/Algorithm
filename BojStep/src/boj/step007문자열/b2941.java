package boj.step007¹®ÀÚ¿­;

import java.util.Scanner;

public class b2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int cnt = 0;

		for (int i = 0; i < word.length(); i++) {
			if(word.charAt(i)=='c') {
				if(i<word.length()-1&&word.charAt(i+1)=='=') {
					i++;
				}else if(i<word.length()-1&&word.charAt(i+1)=='-') {
					i++;
				}
			}else if(word.charAt(i)=='d') {
				if(i<word.length()-1 && word.charAt(i+1)=='z') {
					if(i<word.length()-2&&word.charAt(i+2)=='=') {
						i += 2;
					}
				}else if(i<word.length()-1&&word.charAt(i+1)=='-') {
					i++;
				}

			}else if(word.charAt(i)=='l') {
				if(i<word.length()-1&&word.charAt(i+1)=='j') {
					i++;
				}
			}else if(word.charAt(i)=='n') {
				if(i<word.length()-1&&word.charAt(i+1)=='j') {
					i++;
				}
			}else if(word.charAt(i)=='s') {
				if(i<word.length()-1&&word.charAt(i+1)=='=') {
					i++;
				}
			}else if(word.charAt(i)=='z') {
				if(i<word.length()-1&&word.charAt(i+1)=='=') {
					i++;
				}
			}
			cnt++;
			
		}System.out.println(cnt);
	}

}
