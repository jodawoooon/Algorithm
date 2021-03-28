package review;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class °ýÈ£ÀÇ°ª {
	static Stack<Character> stack = new Stack<>();
	static char[] arr;
	// ( () [ [ ] ] ) ( [ ] )
	//   2*( 2 + 3*3 ) + 2*3 
	// 2 * 2 + 2 * 3 * 3 + 2 * 3
	// 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		arr = str.toCharArray();
		int L = arr.length;
		int tmp = 1;
		int ans = 0;
		for (int i = 0; i <L; i++) {
			if(arr[i]=='(') {
				
				tmp *= 2;
				stack.push(arr[i]);
			}else if(arr[i]=='[') {
				
				tmp *= 3;
				stack.push(arr[i]);
			}else if(arr[i]==')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					ans = 0;
					System.out.println(ans);
					return;
				}
				if(arr[i-1]=='('){
					ans += tmp;
				}
				stack.pop();
				tmp /= 2;

				
			}else {
				if(stack.isEmpty() || stack.peek() != '[') {
					ans = 0;
					System.out.println(ans);
					return;
				}
				if(arr[i-1]=='['){
					ans += tmp;

				}
				stack.pop();
				tmp /= 3;

			}
			
		}
		if(!stack.isEmpty()) ans = 0;
		System.out.println(ans);
		
		
	}
}
