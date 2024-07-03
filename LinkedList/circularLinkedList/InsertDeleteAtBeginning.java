package LinkedList.circularLinkedList;

public class InsertDeleteAtBeginning {
    static Node head;
    public static void main(String[] args){
        insertAtBeg(1);
        insertAtBeg(2);
        insertAtBeg(3);
        insertAtBeg(4);
        printNodes();
        deleteFromBeg();
        printNodes();
        deleteFromBeg();
        printNodes();
        deleteFromBeg();
        printNodes();
        deleteFromBeg();
        printNodes();
    }
    private static void insertAtBeg(int data){
        if(head== null){
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
        head = newNode;
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
    private static void deleteFromBeg(){
        if(head==null)
            return;
        if(head.next==head){
            System.out.println("Deleting node: "+head.data);
            head=null;
        }
        else{
            Node curr=head;
            while (curr.next!=head){
                curr=curr.next;
            }
            System.out.println("Deleting node: "+head.data);
            head=head.next;
            curr.next=head;
        }
    }
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
