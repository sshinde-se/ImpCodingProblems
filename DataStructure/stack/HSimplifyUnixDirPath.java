package DataStructure.stack;


import java.util.Stack;

public class HSimplifyUnixDirPath {
    public static String simplifyPath(String path) {
        String res="";
        Stack<String> stack = new Stack<>();
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) == '/')
                continue;
            String temp="";
            while(i<path.length() && path.charAt(i) != '/'){
                temp += path.charAt(i);
                ++i;
            }
            if(temp.equals("."))
                continue;
            else if(temp.equals("..")){
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else
                stack.push(temp);
        }
        while(!stack.isEmpty()){
            res = '/' + stack.pop() + res;
        }
        if(res.length() == 0)
            return "/";
        return res;
    }

    public static void main(String [] args){
        String s = "/../";
        System.out.println(simplifyPath(s));
        String s1 = "/home//foo/";
        System.out.println(simplifyPath(s1));
        String s2 = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(s2));
    }
}
