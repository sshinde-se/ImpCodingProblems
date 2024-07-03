package ServiceNowCoding;

import java.util.Stack;

public class ImplementQueueUsingSingleStack {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args){
        enQueue(1);
        enQueue(2);
        enQueue(3);

        System.out.println(deQueue());
        System.out.println(deQueue());
    }

    private static int deQueue() {
        if(stack.isEmpty())
            return -1;
        int front = stack.pop();
        if(stack.isEmpty())
            return front;
        else{
            int item=deQueue();
            stack.push(front);
            return item;
        }
    }

    private static void enQueue(int i) {
        stack.push(i);
    }
}
