/******************************************************************************


Without using stack to check if brackets are balanced or not

*******************************************************************************/

public class BracketsBalancedWithoutStack
{
	public static void main(String[] args) {
		String s = "{([)]}";
		if(areBracktesBalanced(s))
		    System.out.println("brackets balanced");
		else
		    System.out.println("brackets are not balanced");
	}
	static boolean areBracktesBalanced(String s){
	    int i = -1;
	    int n = s.length();
	    char [] stack = new char[n];
	    for(char ch: s.toCharArray()){
	        if(ch == '{' || ch == '(' || ch == '['){
	            stack[++i] = ch;
	        }
	        else{
	            if(i >= 0 && ((stack[i] == '{' && ch == '}') || (stack[i] == '(' && ch == ')') ||
	                (stack[i] == '[' && ch == ']')))
	                i--;
	            else
	                return false;
	        }
	    }
	    return (i==-1);
	}
}
