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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        ListNode n = head;
        ListNode k = head.next;
        ListNode next = k.next;
        int i = 1;
        int f = -1;
        int l = -1;
        int minDist = Integer.MAX_VALUE;
        while (next != null) {
            if ((k.val > n.val && k.val > next.val) ||
                (k.val < n.val && k.val < next.val)) {
                if (f == -1) {
                    f = i;
                } else {
                    minDist = Math.min(minDist, i - l);
                }
                l = i;
            }
            n = k;
            k = next;
            next = next.next;
            i++;
        }
        if (f == -1 || l == f) {
            return new int[]{-1, -1};
        }
        return new int[]{minDist, l - f};
    }
}