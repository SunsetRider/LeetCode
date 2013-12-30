/**
 * Problem:
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 *  Given linked list: 1->2->3->4->5, and n = 2.
 *
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass. you want.
 */

/**
 * Aglorithm 1:
 * Use a sentry pointer.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        ListNode sentry = head;
        for (int i = 0; i < n; i++) {
            sentry = sentry.next;

            if (sentry == null) {
                if (i < n-1) {
                    return head;
                } else if (i == n-1) {
                    return head.next;
                }
            }
        }

        sentry = sentry.next;
        ListNode beforeNth = head;
        ListNode Nth = head.next;

        while (sentry != null) {
            beforeNth = beforeNth.next;
            Nth = Nth.next;
            sentry = sentry.next;
        }

        beforeNth.next = Nth.next;
        Nth.next = null;

        return head;
    }
}

