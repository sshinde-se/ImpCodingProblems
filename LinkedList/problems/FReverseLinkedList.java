package LinkedList.problems;

//see video for better understanding
//https://www.youtube.com/watch?v=jY-EUKXYT20
public class FReverseLinkedList {

    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        printNodes();
        System.out.println("Reversing node:");
        head = reverseList();
        printNodes();
        head = reverseListUsingRecursion(head);
        System.out.println("Reversing node:");
        printNodes();
    }
    //https://www.geeksforgeeks.org/reverse-a-linked-list/
    private static Node reverseList() {
        if(head == null){
            return null;
        }
        Node curr=head, prev=null, next=null;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static Node reverseListUsingRecursion(Node head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        Node secondElem = head.next;
        head.next = null;
        Node reverseList = reverseListUsingRecursion(secondElem);
        secondElem.next = head;
        return reverseList;
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
