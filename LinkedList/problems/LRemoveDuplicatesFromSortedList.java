package LinkedList.problems;

public class LRemoveDuplicatesFromSortedList {
    static ListNode head=null;
    public static void main(String[] args){
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head = removeDuplicatesFromSortedList();
        printNodes();
    }
    private static void printNodes(){
        ListNode p=head;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    private static ListNode removeDuplicatesFromSortedList() {
        ListNode curr=head;
        while (curr!=null && curr.next!=null){
            if(curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
