package LinkedList.doubleLinkedList;

public class InsertDeleteNodeAtBeginning {
    static Node head;
    public static void main(String[] args){
        insertAtBeg(11);
        insertAtBeg(22);
        insertAtBeg(33);
        insertAtBeg(44);
        printNodes();
        deleteNodeAtBeg();
        printNodes();
    }
    private static void insertAtBeg(int data){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    private static void printNodes(){
        if(head==null)
            return;
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
    private static void deleteNodeAtBeg(){
        if (head==null)
            return;
        System.out.println("Deleting node:"+head.data);
        head = head.next;
        head.prev = null;
    }
    static class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data=data;
            prev=null;
            next=null;
        }
    }
}
