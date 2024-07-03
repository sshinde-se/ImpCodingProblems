package LinkedList.problems;

public class JMergeTwoSortedList {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head1 = new Node(3);
        head1.next = new Node(4);
        head1.next.next = new Node(7);
        printNodes(head);
        System.out.println();
        printNodes(head1);
        System.out.println();
        System.out.println("Merged sorted list using recursion");
        Node res = mergeSortedListRecursion(head, head1);
        printNodes(res);

        head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(4);
        head2.next.next.next = new Node(5);
        head3 = new Node(3);
        head3.next = new Node(4);
        head3.next.next = new Node(7);
        System.out.println();
        printNodes(head2);
        System.out.println();
        printNodes(head3);
        System.out.println();
        System.out.println("Merged sorted list using iteration");
        Node res1 = mergeSortedListUsingIteration(head2, head3);
        printNodes(res1);
    }
    private static Node mergeSortedListRecursion(Node a, Node b){
        if(a==null)
            return b;
        if(b==null)
            return a;
        Node res=null;
        if(a.data<= b.data){
            res=a;
            res.next = mergeSortedListRecursion(a.next, b);
        }
        else {
            res=b;
            res.next = mergeSortedListRecursion(b.next, a);
        }
        return res;
    }
    private static Node mergeSortedListUsingIteration(Node a, Node b){
        Node newNode = new Node(0);
        Node res=newNode;
        while (true){
            if(a==null){
                res.next=b;
                break;
            }
            if(b==null){
                res.next=a;
                break;
            }
            if(a.data<=b.data){
                res.next = a;
                a = a.next;
            }
            else {
                res.next = b;
                b = b.next;
            }
            res= res.next;
        }

        return newNode.next;
    }
    static Node head=null;
    static Node head1=null;
    static Node head2=null;
    static Node head3=null;
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
