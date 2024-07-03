package DataStructure.stack;

public class EMinStackUsingNode {
    Node head;

    public void push(int val){
        if(head == null)
            head = new Node(val, val, null);
        else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    public void pop(){
        head = head.next;
    }
    public int top(){
        return head.val;
    }
    public int getMin(){
        return head.min;
    }
    static class Node{
        int val;
        int min;
        Node next;
        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String [] args){
        EMinStackUsingNode obj = new EMinStackUsingNode();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
