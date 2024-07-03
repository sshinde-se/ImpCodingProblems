package DataStructure.stack;

import java.util.Stack;
/*
Now the interesting part is, how to handle the case when the minimum element is removed.
 To handle this, we push “2x – minEle” into the stack instead of x so that the previous minimum
  element can be retrieved using the current minEle and its value stored in the stack
 */
public class DMinStack {
    Stack<Long> stack;
    long min;
    public DMinStack() {
        stack = new Stack<>();
    }

    public void push(long val) {
        if(stack.isEmpty()){
            stack.push(val);
            min = val;
        }
        else{
            if(val < min){
                long res = 2 * val - min;
                stack.push(res);
                min = val;
            }
            else{
                stack.push(val);
            }
        }
    }


    public void pop() {
        if(!stack.isEmpty()){
            long res = stack.pop();
            if(res < min){
                min = 2* min - res;
            }
        }
    }

    public long top() {
        if(stack.peek() < min)
            return min;
        else
            return stack.peek();
    }

    public long getMin() {
        return min;
    }

    public static void main(String [] args){
        DMinStack obj = new DMinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */