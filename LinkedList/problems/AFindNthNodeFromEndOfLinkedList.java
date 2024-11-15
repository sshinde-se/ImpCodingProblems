package LinkedList.problems;

public class AFindNthNodeFromEndOfLinkedList {
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
        insertNodeAtEnd(1);
        insertNodeAtEnd(2);
        insertNodeAtEnd(4);
        insertNodeAtEnd(5);
        insertNodeAtEnd(3);
        insertNodeAtEnd(7);
        insertNodeAtEnd(9);
        printNodes(head);
        System.out.println("Node found at 2: "+findNthNodeBruteForce(3).data);
        System.out.println("Node found at 2: "+findNthNodeEfficient(3).data);
    }
    //We can easily find nth node from end by
    // finding the length of linkedlist and then returning count-n+1 th node
    private static Node findNthNodeBruteForce(int n){
        if(head==null)
            return null;
        int count=0;
        Node curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        curr=head;
        int m=1;
        while (curr!=null){
            if(count-n+1==m){
                return curr;
            }
            m++;
            curr=curr.next;
        }
        return null;
    }
    //Use two pointers pNthNode and pTemp. Initially, both point to head node of the list.
    // pNthNode starts moving only after pTemp has made n moves.
    //From there both move forward until pTemp reaches the end of the list. As a result pNthNode points to n
    //th node from the end of the linked list
    private static Node findNthNodeEfficient(int n){
        Node pNthNode=head, ptemp=head;
        for(int cnt=1; cnt<=n; cnt++){
            if(ptemp!=null)
                ptemp=ptemp.next;
        }
        while (ptemp!=null){
            if(pNthNode==null)
                pNthNode=head;
            else
                pNthNode=pNthNode.next;
            ptemp=ptemp.next;
        }
        return pNthNode;
    }
    private static void insertNodeAtEnd( int i) {
        if(head == null){
            head = new Node(i);
            return;
        }
        Node curr=head;
        while (curr.next!=null){
            curr=curr.next;
        }
        curr.next= new Node(i);
    }
    private static void printNodes(Node head){
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
}
