package boj.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_11000_G5_강의실배정 {
	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
	}
	static int N, ans;
	static Node[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		N = Integer.parseInt(br.readLine());
		list = new Node[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[i] = new Node(s,t);

		}
		

		Arrays.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.start==o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
			
		});
		
		pq.offer(list[0].end);
		
		for (int i = 1; i < N; i++) {
			
			if(pq.peek()<=list[i].start) {
				pq.poll();
			}
			pq.add(list[i].end);
		}
		
		System.out.println(pq.size());
		
	}
}
