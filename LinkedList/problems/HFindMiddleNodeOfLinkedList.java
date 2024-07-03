package LinkedList.problems;

public class HFindMiddleNodeOfLinkedList {
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(7);

        printNodes();
        System.out.println("Middle node:");
        System.out.println(findMiddleNodeBruteForce().data);
        System.out.println(findMiddleNodeUsingTwoPointers().data);
    }

    private static Node findMiddleNodeBruteForce() {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        Node curr=head;
        int cnt=0;
        while (curr!=null){
            cnt++;
            curr=curr.next;
        }
        curr=head;
        for(int i=1;i<=cnt/2;i++){
            curr=curr.next;
        }
        return curr;
    }
    private static Node findMiddleNodeUsingTwoPointers() {
        Node slowPtr=head,fastPtr=head;
        while (fastPtr!=null&&fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
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
