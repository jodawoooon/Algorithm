package level2;
import java.util.*;

/***
 * 
 * 
 * ✨ Algorithm ✨
 * @Problem : Programmers 카카오프렌즈 컬러링북
 * @Author : Daun JO
 * @Date : 2021. 9. 19. 
 * @Algorithm : BFS
 *
 */
class Solution_카카오프렌즈컬러링북 {
    static boolean[][] visited;
    static int maxSizeOfOneArea, M, N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea = 0;
        M = m;
        N = n;
            
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i ++){
            for(int j = 0 ; j < n ; j++){
                if(visited[i][j]) continue;
                if(picture[i][j]==0) continue;
                bfs(i,j,picture);
                numberOfArea++;
            }
        }
            

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static void bfs(int x, int y, int[][] picture){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        
        int color = picture[x][y];
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            for(int d = 0 ; d < 4 ; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr,nc)&&!visited[nr][nc]&&
                   color==picture[nr][nc]){
                    cnt++;
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        
        maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
    }
    
    static boolean isIn(int r, int c){
        if(r<0||c<0||r>=M||c>=N) return false;
        return true;
    }
}