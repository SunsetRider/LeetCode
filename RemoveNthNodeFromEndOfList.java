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
        ListNode sentry = head;
        ListNode beforeNth = head;
        ListNode Nth = head;

        for (int i = 0; sentry != null; i++) {
            sentry = sentry.next;
            if (i == n-1 && sentry == null) {
                return head.next;
            }

            if (i == n) {
                beforeNth = head;
                Nth = head.next;
            } else if (i > n) {
                beforeNth = beforeNth.next;
                Nth = Nth.next;
            }
        }

        beforeNth.next = Nth.next;
        Nth.next = null;

        return head;
    }
}


