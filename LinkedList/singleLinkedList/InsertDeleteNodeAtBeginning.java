package LinkedList.singleLinkedList;

public class InsertDeleteNodeAtBeginning {
    static Node head = null;
    public static void main(String[] args){
        insertNodeBeg( 1);
        insertNodeBeg( 2);
        insertNodeBeg( 3);
        printNodes();
        deleteNodeFromBeg();
        deleteNodeFromBeg();
        deleteNodeFromBeg();
        printNodes();
    }
    private static void insertNodeBeg(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    private static void deleteNodeFromBeg(){
        if(head==null)
            return;
        System.out.println("Deleting node with val:"+head.data);
        head=head.next;
    }
    private static void printNodes(){
        Node curr = head;
        while (curr!=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next =null;
        }
    }
}


