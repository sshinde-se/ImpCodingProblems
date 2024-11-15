package LinkedList.circularLinkedList;

public class InsertDeleteAtEnd {
    static Node head;
    public static void main(String[] args){
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        printNodes();
        deleteFromEnd();
        printNodes();
        deleteFromEnd();
        printNodes();
        deleteFromEnd();
        printNodes();
        deleteFromEnd();
        printNodes();
    }
    private static void insertAtEnd(int data){
        if(head == null){
            head = new Node(data);
            head.next = head;
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        Node curr=head;
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next = newNode;

    }
    private static void deleteFromEnd(){
        if(head==null)
            return;
        if(head.next==head){
            System.out.println("Deleting node: "+head.data);
            head=null;
        }else {
            Node curr=head, prev=null;
            while (curr.next!=head){
                prev=curr;
                curr=curr.next;
            }
            System.out.println("Deleting node: "+curr.data);
            prev.next=head;
        }
    }
    private static void printNodes(){
        if(head==null)
            return;
        Node curr=head;
        do{
            System.out.println(curr.data);
            curr = curr.next;
        }while (curr!=head);
    }
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
