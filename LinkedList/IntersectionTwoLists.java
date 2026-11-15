package LinkedList;
public class IntersectionTwoLists {
    static class ListNode { int val; ListNode next; ListNode(int v) { val = v; } }
    public static ListNode getIntersection(ListNode a, ListNode b) {
        ListNode p1 = a, p2 = b;
        while (p1 != p2) { p1 = (p1 == null) ? b : p1.next; p2 = (p2 == null) ? a : p2.next; }
        return p1;
    }
    public static void main(String[] args) { System.out.println(getIntersection(null, null)); }
}
