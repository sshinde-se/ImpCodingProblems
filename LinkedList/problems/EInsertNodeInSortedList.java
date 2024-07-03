package LinkedList.problems;

public class EInsertNodeInSortedList {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        printNodes();
        System.out.println("After adding new node:");
        insertNodeInSortedList(4);
        printNodes();
    }

    private static void insertNodeInSortedList(int data) {
        if(head == null){
            head = new Node(data);
        }
        Node curr=head, prev=null;
        while (curr!=null && curr.data<data){
            prev = curr;
            curr =curr.next;
        }
        Node newNode = new Node(data);
        newNode.next = curr;
        prev.next = newNode;

    }

    static Node head=null;
    private static void printNodes(){
        Node curr=head;
        do{
            System.out.println(curr.data);
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
