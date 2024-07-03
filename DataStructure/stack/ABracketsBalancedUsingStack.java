package DataStructure.stack; /******************************************************************************

Using stack to check if brackets are balanced or not

*******************************************************************************/
import java.util.*;
public class ABracketsBalancedUsingStack
{
	public static void main(String[] args) {
		String s = "{()[]}";
		if(areBracketsBalanced(s))
		    System.out.println("brackets balanced");
		else
		    System.out.println("brackets are not balanced");
		String s1 = "{()[]}";
		if(areBracketsBalancedOptimal(s1))
			System.out.println("brackets balanced");
		else
			System.out.println("brackets are not balanced");
	}
	static boolean areBracketsBalanced(String s){
	    Deque<Character> stack = new ArrayDeque<Character>();
	    
	    for(int i=0; i<s.length(); i++){
	        char x = s.charAt(i);
	        if(x == '{' || x == '(' || x == '['){
	            stack.push(x);
	            continue;
	        }
	        if (stack.isEmpty())
                return false;
	        char check;

	        switch(x){
	            case '}':
	                check = stack.pop();
	                if(check == '(' || check == '[')
	                    return false;
	                break;
	            case ')':
	                check = stack.pop();
	                if(check == '{' || check == ']')
	                    return false;
	                break;
	            case ']':
	                check = stack.pop();
	                if(check == '(' || check == '{')
	                    return false;
	                break;
	        }
	    }
	    return stack.isEmpty();
	}

	static boolean areBracketsBalancedOptimal(String s){
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()){
			if(c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if(stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
