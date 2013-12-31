/**
 * Problem:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

/**
 * Aglorithm 1:
 * Swap each pair of the nodes and use a variable store the tail of the swapped list.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode result = head.next;
        ListNode tail = null; // store the swapped list's tail
        for (ListNode former = head; former != null; former = former.next) {
            if (former.next == null) {
                break;
            }

            ListNode latter = former.next;

            former.next = latter.next;
            latter.next = former;
            if (tail != null) {
                tail.next = latter;
            }

            tail = former;
        }

        return result;
    }
}
