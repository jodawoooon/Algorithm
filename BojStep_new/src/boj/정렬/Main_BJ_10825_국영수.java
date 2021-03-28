package boj.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_10825_국영수 {
	
	static int N;
	
	static class Student{
		String name;
		int kor;
		int eng;
		int math;
		public Student(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
	}
	
	
	static ArrayList<Student> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			list.add(new Student(name,kor,eng,math));
		}
		
		
		
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.kor!=o2.kor) {
					return o2.kor-o1.kor;
				}else {
					if(o1.eng!=o2.eng) {
						return o1.eng - o2.eng;
					}else {
						if(o1.math!=o2.math) {
							return o2.math - o1.math;
						}else {
							return o1.name.compareTo(o2.name);
						}
					}
				}
			}
			
		});
		
		
		
		for (Student std : list) {
			System.out.println(std.name);
		}
	}
}
