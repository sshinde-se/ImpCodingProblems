package LinkedList.problems;

import java.util.HashSet;

public class DFindLinkedListIsNullTerminatedOrContainsCycle {
    static Node head=null;
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printNodes();
        System.out.print(isCircularUsingHashSet() ? "Yes\n" : "No\n");
        System.out.print(isCircularUsingFastAndSlowPointer() ? "Yes\n" : "No\n");

        // Making linked list circular
        head.next.next.next.next = head;
        printNodes();
        System.out.print(isCircularUsingHashSet() ? "Yes\n" : "No\n");
        System.out.print(isCircularUsingFastAndSlowPointer() ? "Yes\n" : "No\n");
    }

    private static boolean isCircularUsingHashSet() {
        if(head==null)
            return true;
        HashSet<Node> hashSet = new HashSet<>();
        Node curr=head;
        while (curr!=null){
            if(hashSet.contains(curr))
                return true;
            hashSet.add(curr);
            curr=curr.next;
        }
        return false;
    }
    private static boolean isCircularUsingFastAndSlowPointer(){
        if(head==null)
            return true;
        Node slowPtr=head, fastPtr=head;
        while (slowPtr!=null && fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
                return true;
        }
        return false;
    }
    private static void printNodes(){
        Node curr=head;
        do{
            System.out.println(curr.data);
            curr=curr.next;
        }while (curr!=null && curr!=head);
    }
}
