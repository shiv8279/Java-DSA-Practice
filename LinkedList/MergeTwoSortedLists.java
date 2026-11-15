package LinkedList;
public class MergeTwoSortedLists {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0), c = d;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { c.next = l1; l1 = l1.next; }
            else { c.next = l2; l2 = l2.next; }
            c = c.next;
        }
        c.next = (l1 != null) ? l1 : l2;
        return d.next;
    }
    public static void main(String[] args) { System.out.println(merge(new ListNode(1), new ListNode(2)).val); }
}
