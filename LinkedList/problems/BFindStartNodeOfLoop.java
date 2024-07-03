package LinkedList.problems;

public class BFindStartNodeOfLoop {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Making linked list circular
        head.next.next.next.next.next = head.next;
        //printNodes();
        System.out.print("Start of loop: "+findStartOfLoopUsingFastAndSlowPointer().data);
    }

    private static Node findStartOfLoopUsingFastAndSlowPointer() {
        if(head==null)
            return null;
        Node slowPtr=head, fastPtr=head;
        boolean loopExists=false;
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
            slowPtr = head;
            while (slowPtr != fastPtr){
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return slowPtr;
        }
        return null;
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
