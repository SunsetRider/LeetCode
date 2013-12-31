/**
 * Problem:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/**
 * Aglorithm 1:
 * Merge fist list with each rest list in the array.
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
import java.util.ArrayList;

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        ListNode result = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            result = mergeTwoLists(result, lists.get(i));
        }

        return result;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode pointerA = a;
        ListNode pointerB = b;
        ListNode result = new ListNode(0);
        ListNode pointerResult = result;
        while (pointerA != null || pointerB != null ) {
            if (pointerA == null) {
                pointerResult.next = pointerB;
                pointerB = pointerB.next;
            } else if (pointerB == null) {
                pointerResult.next = pointerA;
                pointerA = pointerA.next;
            } else if (pointerA.val < pointerB.val) {
                pointerResult.next = pointerA;
                pointerA = pointerA.next;
            } else {
                pointerResult.next = pointerB;
                pointerB = pointerB.next;
            }

            pointerResult = pointerResult.next;
        }

        return result.next;
    }
}
