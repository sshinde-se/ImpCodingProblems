package LinkedList.problems;

public class CFindLengthOfLoopInCyclicLinkedList {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Making linked list circular
        head.next.next.next.next.next = head.next;
        //printNodes();
        System.out.print("Length of loop: "+findStartOfLoopUsingFastAndSlowPointer());
    }

    private static int findStartOfLoopUsingFastAndSlowPointer() {
        if(head==null)
            return 0;
        Node slowPtr=head, fastPtr=head;
        boolean loopExists=false;
        int count = 0;
        while (slowPtr!=null && fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr)
            {
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            fastPtr = fastPtr.next;
            while (slowPtr != fastPtr){
                fastPtr = fastPtr.next;
                count++;
            }
            return count+1;
        }
        return 0;
    }

    private static void printNodes(){
        Node curr=head;
        do{
            System.out.println(curr.data);
            curr=curr.next;
        }while (curr!=null && curr!=head);
    }
    static Node head=null;
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
