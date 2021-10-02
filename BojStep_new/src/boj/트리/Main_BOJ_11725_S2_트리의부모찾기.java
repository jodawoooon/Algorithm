 package boj.트리;

import java.io.*;
import java.util.*;

public class Main_BOJ_11725_S2_트리의부모찾기 {
    static Node[] nodeList;
    static class Node {
        int id;
        int parent;
        ArrayList<Node> adjList;
        public Node(int id) {
        	this.id = id;
        	this.adjList = new ArrayList<>();
        }
    }
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nodeList= new Node[N+1];
        StringTokenizer st;

        for(int i = 1 ; i <= N ; i ++){
            nodeList[i] = new Node(i);
        }

        for(int i = 0 ; i < N-1 ; i ++){
            //연결된 두 정점	
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            //양방향 연결
            nodeList[v1].adjList.add(nodeList[v2]);
            nodeList[v2].adjList.add(nodeList[v1]);
        }

        bfs();

        // 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
        for(int i = 2 ; i <= N ; i++){
            System.out.println(nodeList[i].parent);
        }
    }

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        //1번노드가 루트노드
        q.add(nodeList[1]); //루트노드에서 부터 탐색한다.
        visited[nodeList[1].id] = true;

        while(!q.isEmpty()){
            Node curNode = q.poll();

            for(Node nextNode : curNode.adjList){ 	//curNode의 인접노드들 탐색
                if(visited[nextNode.id]) continue;
                visited[nextNode.id] = true;
                nextNode.parent = curNode.id; //나의 부모를 저장한다. (내가 curNode로부터 왔기 때문)
                q.add(nextNode);
            }
        }
    }
}
