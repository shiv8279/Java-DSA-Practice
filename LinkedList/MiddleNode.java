package LinkedList;
public class MiddleNode {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public static ListNode middle(ListNode h) {
        ListNode s = h, f = h;
        while (f != null && f.next != null) { s = s.next; f = f.next.next; }
        return s;
    }
    public static void main(String[] args) { System.out.println(middle(new ListNode(1)).val); }
}
