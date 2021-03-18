package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_sol {
	static int L, S, maxNum, maxDepth;
	static boolean[][] graph;
	static Queue<Node> queue = new LinkedList<Node>();
	static boolean[] visit;
	static class Node{
		int n;
		int depth;
		public Node(int n, int depth) {
			super();
			this.n = n;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1238input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t =1; t <=10; t++) {
			
			graph = new boolean[101][101];
			visit = new boolean[101];
			maxNum = Integer.MIN_VALUE;
			maxDepth = Integer.MIN_VALUE;
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) {
				graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]= true;
				
			}
			
			visit[S] = true;
			queue.offer(new Node(S,0));
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(node.depth > maxDepth) {
					maxDepth = node.depth;
					maxNum= node.n;
				}else if(node.depth==maxDepth) {
					maxNum = Math.max(maxNum, node.n);
				}
				
				for (int i = 1; i <=100; i++) {
					if(!visit[i]&&graph[node.n][i]) {
						visit[i]=true;
						queue.offer(new Node(i, node.depth+1));
					}
				}
				
			}
			
			System.out.println("#"+t+" "+maxNum);
		}
	}
	
}
