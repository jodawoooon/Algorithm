package level3;

import java.util.*;

public class Solution_N_Queen {
    
    static int[] map;
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        
        for(int i = 0 ; i < n ; ++i) {
            map = new int[n];
            map[0] = i;
            backtracking(n, 1);
        }
        
        return answer;
    }
    
    private void backtracking(int max, int row){
        if(row == max){
            answer++;
            map[row - 1] = 0;
            return;
        }
        
        for(int i = 0 ; i < max ; ++i){
            map[row] = i;
            if(isPossible(row)){
                backtracking(max, row + 1);
            } else {
                map[row] = 0;
            }
        }
        map[row] = 0;
    }
    
    private boolean isPossible(int row){
        for(int i = 0 ; i < row ; ++i){
            if(map[i] == map[row]) return false;
            if(Math.abs(row - i) == Math.abs(map[row] - map[i])) return false;
        }
        
        return true;
    }
   
}