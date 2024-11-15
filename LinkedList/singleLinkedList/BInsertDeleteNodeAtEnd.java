package LinkedList.singleLinkedList;

public class BInsertDeleteNodeAtEnd {
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
        insertNodeAtEnd(3);
        printNodes();
        deleteNodeFromLast();
        deleteNodeFromLast();
        deleteNodeFromLast();
        printNodes();
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
    private static void deleteNodeFromLast(){
        if(head==null)
            return;
        if(head.next==null){
            System.out.println("Deleting node with val:"+head.data);
            head=null;
            return;
        }
        Node curr=head, prev = curr;
        while (curr.next!=null){
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Deleting node with val:"+curr.data);
        prev.next = curr.next;
    }
    private static void printNodes(){
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
}
