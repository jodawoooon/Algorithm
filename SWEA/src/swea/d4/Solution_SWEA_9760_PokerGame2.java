package swea.d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9760_PokerGame2 {
	/*
	 * 
	 *  4개의 슈트
	 *  (모양: S, D, H, C)
	 *  13개의 랭크
	 *  (값 : A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K)
	 *  
	 *  
	 *  
	 * 1. Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다(여기서는 로얄 플러쉬를 포함한다. 로얄 플러쉬는 모두 동일한 슈트에 T, J, Q, K, A를 갖는다).
	 * 2. Four of a Kind : 5장 중 4개의 랭크(값)가 모두 같다.
	 * 3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
	 * 4. Flush : 5장이 모두 동일한 슈트다.
	 * 5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
	 * 6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3).
	 * 7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3).
	 * 8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7).
	 * 9. High card : 1~8번에 해당하지 않는다.
	 * 
	 */
    
    
   static String ans, poker[];
   static int res;
   static int[] suit, rank;
   static int sSize = 4;
   static int rSize = 13;
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = null;
       //기본 셋팅
        
       int T = Integer.parseInt(br.readLine()); //테케 갯수
        
        
       for (int t = 1; t <= T; t++) {
            
           poker = new String[5]; //입력받은 카드를 저장할 배열
           suit = new int[sSize]; //슈트 : S, D, H, C
           rank = new int[rSize]; //랭크 : A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K
                        
           st = new StringTokenizer(br.readLine());
           for (int i = 0; i < 5; i++) {
               poker[i] = st.nextToken(); //입력받은 카드
                
               setSuit(poker[i].charAt(0)); 
               //입력받은 카드의 suit를 체크하고, 해당 suit배열에 갯수를 넣는다
               setRank(poker[i].charAt(1));
               //입력받은 카드의 rank를 체크하고, 해당 rank배열에 갯수를 넣는다
         
           }
           //카드 정보 셋팅
            
            
           res=0;
            
           boolean flush = false; // 모두 같은 슈트인지 확인할 flag
            
           for (int i = 0; i < sSize ; i++) { //슈트에 대해 체크
               if(suit[i]==5) {
                   flush=true;
                   break;
               }
                
               //슈트 갯수가 5개인게 있으면,flush 따라서 flush=true
           }
            
           int conRank = 0; //연속된 숫자의 개수
           boolean fourK = false; // 4개의 랭크가 같은지 확인할 flag
           int fullHouse = 0; //full House인지 확인할 변수
           boolean threeK = false; //three of a kind인지 확인할 flag
           int pair = 0; //two pair, one pair인지 확인할 cnt
            
           for (int i = 0; i < rSize; i++) {
               if(rank[i]!=0) conRank = Math.max(conCheck(i), conRank); //conRank는 연속된 최대 숫자를 기록한다.
                
               if(rank[i]==3) { //동일 랭크가 3장 있다면
                   threeK = true;
                   fullHouse++;
               }
               if(rank[i]==2) {
                   pair++; //동일 랭크가 2장있으면
                   fullHouse++; 
               }
               if(rank[i]==4) fourK = true; //동일 랭크가 4개 있다면
                
           }

           //System.out.println(conRank);
           if(flush&&conRank==5) res=1; //1. Straight Flush ; 모두 동일한 슈트에 랭크(값)가 모두 연속적이면 res=1
           else if(fourK) res=2; //2. Four of a Kind ; 5장 중 4개의 랭크(값)가 모두 같다.
           else if(fullHouse==2&&pair!=2) res = 3; //3. Full House ; 3장의 동일한 랭크(값)와 2장의 동일한 랭크
           else if(flush) res=4; //4. Flush ; 5장이 모두 동일한 슈트다.
           else if(conRank==5) res=5;  //5. Straight ; 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
           else if(threeK) res=6; //6. Three of a kind ; 동일한 랭크(값)가 3장
           else if(pair==2) res=7; //7. Two pair ; 동일한 랭크(값) 2장씩 두개의 랭크다
           else if(pair==1) res=8; //8. One pair ; 동일한 랭크가 2장
           //9. High card : 1~8번에 해당하지 않는다.
            
           //결과 출력
           answerPrint(t, res);
           
       }
   }
    
   private static int conCheck(int start) {
       int cnt = 0;
       for (int i = start; i < start+5; i++) {
           if(rank[i%rSize] == 0) {
               return cnt;
           }
           else cnt++;
       }
       return cnt;
   }

    

   private static void answerPrint(int t, int res) {
       switch(res) { //res에 저장된 수에 따라, 결과 String을 ans에 넣어준다.
       case 1: ans = "Straight Flush"; break;
       case 2: ans = "Four of a Kind"; break;
       case 3: ans = "Full House"; break;
       case 4: ans = "Flush"; break;
       case 5: ans = "Straight"; break;
       case 6: ans = "Three of a kind"; break;
       case 7: ans = "Two pair"; break;
       case 8: ans = "One pair"; break;
       case 0: ans = "High card"; break;   
       }
       System.out.println("#"+t+" "+ans);
   }

   private static void setRank(char c) { 
       //입력받은 카드의 랭크를 기록하는 메소드
       switch(c) { //카드의 랭크
       case 'A':
           rank[0]++;break;
       case '2' : 
           rank[1]++; break;
       case '3' : 
           rank[2]++; break;
       case '4' : 
           rank[3]++; break;
       case '5' : 
           rank[4]++; break;
       case '6' : 
           rank[5]++; break;
       case '7' : 
           rank[6]++; break;
       case '8' : 
           rank[7]++; break;
       case '9' : 
           rank[8]++; break;
       case 'T' : 
           rank[9]++; break;
       case 'J' : 
           rank[10]++; break;
       case 'Q' : 
           rank[11]++; break;
       case 'K' : 
           rank[12]++; break;
       }
       //해당 랭크 인덱스의 개수를 증가시킨다.
        
   }
    
   private static void setSuit(char c) {
       //입력하는 카드의 슈트를 기록하는 메소드
       switch(c) { //카드의 슈트
       case 'S':
           suit[0]++; break;
       case 'D':
           suit[1]++; break;
       case 'H':
           suit[2]++; break;
       case 'C':
           suit[3]++; break;
       }
       //해당 슈트 인덱스의 개수를 증가시킨다.
   }
}
    