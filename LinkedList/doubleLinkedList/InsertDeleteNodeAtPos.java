package LinkedList.doubleLinkedList;

public class InsertDeleteNodeAtPos {
    static Node head;
    public static void main(String[] args){
        insertAtPos(11,1);
        insertAtPos(22, 1);
        insertAtPos(33, 2);
        insertAtPos(44, 3);
        insertAtPos(55, 2);
        printNodes();
        deleteNodeAtPos(2);
        printNodes();
    }
    private static void insertAtPos(int data, int pos){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node newNode = new Node(data);
        if(pos == 1){
            newNode.next = head;
            if(head.prev==null)
                head.prev = newNode;
            head = newNode;
        }else {
            int k=1;
            Node tmp=head;
            while (tmp.next!=null&& k<pos){
                tmp = tmp.next;
            }
            if(k!=pos-1)
                System.out.println("Position not exists");
            newNode.next=tmp.next;
            newNode.prev=tmp;
            if(tmp.next!=null){
                tmp.next.prev=newNode;
            }
            tmp.next=newNode;
        }
    }
    private static void printNodes(){
        if(head==null)
            return;
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
    private static void deleteNodeAtPos(int pos){
        if (head==null)
            return;
        if(head.next==null){
            System.out.println("Deleting node:"+head.data);
            head = null;
        }
        else{
            int k=1;
            Node tmp=head, tmp1;
            while (tmp!=null&& k<pos){
                k++;
                tmp = tmp.next;
            }
            if(k!=pos-1)
                System.out.println("Position not exists");
            if(tmp!=null){
                System.out.println("Deleting node:"+tmp.data);
                tmp1 = tmp.next;
                tmp.prev.next = tmp1;
                tmp1.prev = tmp.prev;
            }
        }
    }
    static class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data=data;
            prev=null;
            next=null;
        }
    }
}
