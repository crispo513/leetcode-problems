/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;

        while (node2 != null) {
            int GCDval = gcd(node1.val, node2.val);
            ListNode gcdNode = new ListNode(GCDval);
            node1.next = gcdNode;
            gcdNode.next = node2;
            node1 = node2;
            node2 = node2.next;
        }

        return head;       

    }
}