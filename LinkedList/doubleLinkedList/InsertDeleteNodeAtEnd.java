package LinkedList.doubleLinkedList;

public class InsertDeleteNodeAtEnd {
    static Node head;
    public static void main(String[] args){
        insertAtEnd(11);
        insertAtEnd(22);
        insertAtEnd(33);
        insertAtEnd(44);
        printNodes();
        deleteNodeAtEnd();
        printNodes();
        deleteNodeAtEnd();
        printNodes();
        deleteNodeAtEnd();
        printNodes();
        deleteNodeAtEnd();
        printNodes();
    }
    private static void insertAtEnd(int data){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr=head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
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
    private static void deleteNodeAtEnd(){
        if (head==null)
            return;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        if(curr.prev==null){
            System.out.println("Deleting node:"+curr.data);
            head = null;
            return;
        }
        System.out.println("Deleting node:"+curr.data);
        curr.prev.next = null;
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
