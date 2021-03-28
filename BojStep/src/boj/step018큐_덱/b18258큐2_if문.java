package boj.step018큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b18258큐2_if문 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int last = 0;
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String order = st.nextToken();
			if(order.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				queue.offer(last);
				continue;
			}else if(!queue.isEmpty()&&order.equals("pop")) {
				sb.append(queue.poll()+"\n");
				continue;
				
			}else if(order.equals("size")) {
				sb.append(queue.size()+"\n");
				continue;
				
			}else if(order.equals("empty")) {
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				continue;
				
			}else if(order.equals("front")&&!queue.isEmpty()) {
				sb.append(queue.peek()+"\n");
				continue;
				
			}else if(order.equals("back")&&!queue.isEmpty()) {
				sb.append(last+"\n");
				continue;
				
			}else if(queue.isEmpty()) {
				sb.append("-1\n");
			}
			
			//queue를  array화 해서 데이터를 빼오니까 시간초과가 났다. push하면서 Int형 데이터에 값을 넣어 기록하다가
			//back 명령어가 들어오면 그 때의 마지막 push값을 append 해주면 됨
			//Stringbuilder안써도 시간초과남
			
			//switch문 안쓰고 if문쓰는게 더 빠르다
		}
		System.out.println(sb);
	}
}
