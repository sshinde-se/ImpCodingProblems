package LinkedList.circularLinkedList;

public class CountNoOfNodesInCircular {
    static Node head;
    public static void main(String[] args){
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        printNodes();
        System.out.println(countNoOfNodes());
    }
    private static int countNoOfNodes(){
        if(head==null)
            return 0;
        else{
            int count=0;
            Node curr=head;
            do{   //here head should get counted that's why we used do while loop
                count++;
                curr=curr.next;
            }while (curr!=head);
            return count;
        }
    }
    private static void printNodes(){
        if(head==null)
            return;
        Node curr=head;
        do{
            System.out.println(curr.data);
            curr = curr.next;
        }while (curr!=head);
    }
    private static void insertAtEnd(int data){
        if(head == null){
            head = new Node(data);
            head.next = head;
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        Node curr=head;
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next = newNode;

    }
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
