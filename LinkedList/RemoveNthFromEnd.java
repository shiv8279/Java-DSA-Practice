package LinkedList;
public class RemoveNthFromEnd {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public static ListNode removeNth(ListNode h, int n) {
        ListNode d = new ListNode(0); d.next = h;
        ListNode f = d, s = d;
        for (int i = 0; i <= n; i++) f = f.next;
        while (f != null) { f = f.next; s = s.next; }
        s.next = s.next.next;
        return d.next;
    }
    public static void main(String[] args) { System.out.println(removeNth(new ListNode(1), 1)); }
}
