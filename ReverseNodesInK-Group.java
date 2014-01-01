/**
 * Problem:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 */

/**
 * Aglorithm 1:
 * Main thought:
 * 1.Check whether the list has k nodes from the given node(inclusive);
 * 2.if so, reverse the k nodes.
 * Tricky point: mark the tail of the last reversed nodes to stitch the nodes.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null) {
            return head;
        }

        ListNode result = null;

        ListNode before = null;
        ListNode current = head;
        ListNode after = head.next;
        ListNode tail = null;     // the tail of the new KGroup
        ListNode lastTail = null; // last tail of KGroup
        ListNode check = current; // used for check if the list has k nodes from this node(inculsive)

        while (current != null) {
            if (!hasKNodes(check, k)) {
                // the original list has less than k nodes
                if (result == null) {
                    return head;
                }
                tail.next = current;
                break;
            }

                tail = current;
            // reverse the k nodes
            for (int i = k; i > 0; i--) {
                after = current.next;
                current.next = before;

                before = current;
                current = after;
            }

            if (result == null) {
                result = before;
            } else {
                lastTail.next = before;
            }
            lastTail = tail;
            before = null;

            check = current;
        }

        return result;
    }

    // check whether the list has k nodes from the given node(inclusive)
    public boolean hasKNodes (ListNode check, int k) {
        while (k != 0) {
            if (check == null) {
                return false;
            }

            check = check.next;
            k--;
        }

        return true;
    }
}
