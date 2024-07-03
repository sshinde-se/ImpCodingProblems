package LinkedList.problems;

import java.util.HashSet;

public class GCheckTwoListHasIntersection {
    private static boolean checkListIntersectionBruteForce(Node head, Node head1){
        if(head == null || head1 ==null)
            return false;
        Node curr=head, curr1=head1;
        while (curr!=null){
            while (curr1!=null){
                if(curr == curr1)
                    return true;
                curr1=curr1.next;
            }
            curr1=head1;
            curr=curr.next;
        }
        return false;
    }
    public static boolean checkIntersectionUsingHashSet(Node head, Node head1){
        HashSet<Node> hashSet=new HashSet<>();
        Node curr=head, curr1=head1;
        while(curr!=null){
            hashSet.add(curr);
            curr=curr.next;
        }
        while (curr1!=null){
            if(hashSet.contains(curr1))
                return true;
            curr1=curr1.next;
        }
        return false;
    }
    public static boolean checkIntersectionUsingDiffInList(Node head, Node head1){
        int cnt1=0,cnt2=0;
        Node curr=head, curr1=head1;
        while(curr!=null){
            cnt1++;
            curr=curr.next;
        }
        while (curr1!=null){
            cnt2++;
            curr1=curr1.next;
        }
        curr=head; curr1=head1;
        int d=Math.abs(cnt1-cnt2);
        if(cnt1>cnt2){
            for(int i=0;i<d;i++){
                curr=curr.next;
            }
            while (curr!=null&&curr1!=null){
                if(curr==curr1)
                    return true;
                curr=curr.next;
                curr1=curr1.next;
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head1 = new Node(3);
        head1.next = head.next.next;
        printNodes(head);
        System.out.println();
        printNodes(head1);
        System.out.println();
        System.out.println("Brute Force: "+checkListIntersectionBruteForce(head, head1));
        System.out.println("Using hashset:" + checkIntersectionUsingHashSet(head, head1));
        System.out.println("Using List diff:" + checkIntersectionUsingDiffInList(head, head1));
    }
    static Node head=null;
    static Node head1=null;
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
