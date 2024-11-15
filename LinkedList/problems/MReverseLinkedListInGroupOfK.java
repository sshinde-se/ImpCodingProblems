package LinkedList.problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MReverseLinkedListInGroupOfK {
    
    static Node head=null,head1 = null,head2 = null;
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        printNodes(head);

        System.out.println();
        System.out.println("Displaying reverse in k groups Iterative:");
        Node res = reverseLinkedListInGroupOfKUsingIterativeMethod(head, 4);
        printNodes(res);
        System.out.println();

        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(5);
        head1.next.next.next.next = new Node(7);
        System.out.println("Displaying reverse in k groups Dequeue:");
        Node res1 = reverseLinkedListInGroupOfKUsingDequeue(head1, 4);
        printNodes(res1);
        System.out.println();

        head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(5);
        head2.next.next.next.next = new Node(7);
        System.out.println("Displaying reverse in k groups Stack:");
        Node res2 = reverseLinkedListInGroupOfKUsingStack(head2, 4);
        printNodes(res2);
    }

    private static Node reverseLinkedListInGroupOfKUsingStack(Node head2, int i) {
        Stack<Node> stack = new Stack<>();
        Node curr = head2;
        Node res= null;

        while (curr!=null){
            int cnt = 0;
            while (curr!=null && cnt<i){
                stack.push(curr);
                curr = curr.next;
                cnt++;
            }

            while (!stack.isEmpty()){
                if(res == null){
                    res = stack.pop();
                    head2 = res;
                }
                else {
                    res.next = stack.pop();
                    res = res.next;
                }
            }
        }
        res.next = null;
        return head2;
    }

    private static Node reverseLinkedListInGroupOfKUsingDequeue(Node head1, int i) {
        Deque<Node> deque = new LinkedList<>();
        Node curr= head1;

        while (curr!=null){
            int cnt=0;
            while (curr!=null && cnt < i){
                deque.addLast(curr);
                curr = curr.next;
                cnt++;
            }
            while (!deque.isEmpty()) {
                Node first = deque.peekFirst();
                Node last = deque.peekLast();

                int tmp = first.data;
                first.data = last.data;
                last.data = tmp;

                if (!deque.isEmpty())
                    deque.pollFirst();
                if (!deque.isEmpty())
                    deque.pollLast();
            }
        }
        return head1;
    }

    private static Node reverseLinkedListInGroupOfKUsingIterativeMethod(Node head, int k) {
        Node curr =head;
        Node newHead = null;
        Node tail = null;

        while (curr!=null){
            Node headGroup = curr;
            Node prev = null, next = null;
            int cnt=0;

            while (curr!=null && cnt < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt++;
            }

            if(newHead == null)
                newHead = prev;

            if(tail!=null)
                tail.next = prev;
            tail = headGroup;
        }
        return newHead;
    }

    private static void printNodes(Node head){
        Node curr=head;
        do{
            System.out.print(" "+curr.data);
            curr=curr.next;
        }while (curr!=null && curr!=head);
    }
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
