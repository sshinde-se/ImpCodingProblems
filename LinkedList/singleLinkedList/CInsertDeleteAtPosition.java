package LinkedList.singleLinkedList;

public class CInsertDeleteAtPosition {
    static Node head=null;

    public static void main(String[] args){

        insertNodeAtPos( 11, 1);
        insertNodeAtPos( 22, 2);
        insertNodeAtPos(33, 3);
        insertNodeAtPos( 44, 2);
        printNodes();
        deleteNodeAtPos(2);
        printNodes();
        deleteNodeAtPos(2);
        printNodes();
        deleteNodeAtPos(3);
        printNodes();
        deleteNodeAtPos(1);
        printNodes();
    }

    private static void insertNodeAtPos(int i, int pos) {
        if(head == null){
            head = new Node(i);
            return;
        }
        Node newNode=new Node(i);
        Node p=head;
        Node q = null;
        int k=0;
        if(pos==1){
            newNode.next = p;
            head=newNode;
        }
        else{
            while (p!=null && k<pos){
                k++;
                q=p;
                p=p.next;
            }
            q.next =newNode;
            newNode.next=p;
        }
    }
    private static void deleteNodeByData(int val){
        Node tmp= head, prev = null;
        if(tmp!=null && tmp.data == val){
            head = head.next;
            return;
        }
        while (tmp!=null && tmp.data!=val){
            prev = tmp;
            tmp = tmp.next;
        }
        if(tmp==null)
            return;
        System.out.println("Deleting Node with val:"+tmp.data);
        prev.next=tmp.next;
    }
    private static void deleteNodeAtPos(int pos){
        if(head==null)
            return;
        if(pos==1){
            System.out.println("Deleting node with val:"+head.data);
            head = head.next;
        }
        else{
            Node curr=head, prev=null;
            int k=1;
            while (curr!=null&&k<pos){
                k++;
                prev = curr;
                curr = curr.next;
            }
            if(curr==null){
                System.out.println("position not exists");
            }else{
                System.out.println("Deleting node with val:"+curr.data);
                prev.next=curr.next;
            }

        }
    }
    private static void printNodes(){
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
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
