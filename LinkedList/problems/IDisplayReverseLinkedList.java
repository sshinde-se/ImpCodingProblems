package LinkedList.problems;

public class IDisplayReverseLinkedList {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        printNodes();
        System.out.println("Displaying reverse:");
        printReverse(head);
    }

    private static void printReverse(Node head) {
        if(head==null)
            return;
        printReverse(head.next);
        System.out.println(head.data);
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
