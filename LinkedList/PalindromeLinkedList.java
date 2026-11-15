package LinkedList;
public class PalindromeLinkedList {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public static boolean isPal(ListNode h) {
        if (h == null || h.next == null) return true;
        ListNode s = h, f = h;
        while (f.next != null && f.next.next != null) { s = s.next; f = f.next.next; }
        ListNode rev = null, cur = s.next;
        while (cur != null) { ListNode n = cur.next; cur.next = rev; rev = cur; cur = n; }
        while (rev != null) { if (h.val != rev.val) return false; h = h.next; rev = rev.next; }
        return true;
    }
    public static void main(String[] args) { System.out.println(isPal(new ListNode(1))); }
}
