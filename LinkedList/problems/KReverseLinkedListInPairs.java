package LinkedList.problems;

public class KReverseLinkedListInPairs {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        printNodes(head);
        System.out.println();
        System.out.println("Displaying reverse:");
        Node res = reverseInPairsRecursion(head);
        printNodes(res);
    }
    private static Node reverseInPairsRecursion(Node head){
        Node tmp=null;
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        else{
            tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = tmp;
            head.next.next = reverseInPairsRecursion(head.next.next);
            return head;
        }
    }

    static Node head=null;
    private static void printNodes(Node head){
        Node curr=head;
        do{
            System.out.print(" "+curr.data);
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
