package boj.step006함수;

public class b4673 {
	static int[] selfNum = new int[10100];
	public static void main(String[] args) {
		for (int i = 1; i <= 10000; i++) {
			d(i);
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(selfNum[i]==0) {
				System.out.println(i);
			}
			
		}
	}
	static void d(int n) {
		int sum = n;
		while(n>0) {
			sum += n % 10; //각 자리 수를 더한다.
			n = n /10; //자리수를 줄여나간다.
		}
		selfNum[sum]++; //해당 인덱스를 ++
	}

}
