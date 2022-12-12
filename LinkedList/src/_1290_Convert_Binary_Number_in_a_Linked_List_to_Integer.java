/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * The most significant bit is at the head of the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * <p>
 * Input: head = [0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */

/**
 * Here we have two subproblems:
 * <p>
 * To parse non-empty linked list and to retrieve the digit sequence which represents a binary number.
 * <p>
 * To convert this sequence into the number in decimal representation.
 * <p>
 * The first subproblem is easy because the linked list is guaranteed to be non-empty.
 */
public class _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {

    /**
     * Approach 1: Binary Representation
     * <p>
     * Initialize result number to be equal to head value: num = head.val. This operation is safe because the list is guaranteed to be non-empty.
     * <p>
     * Parse linked list starting from the head: while head.next:
     * <p>
     * The current value is head.next.val. Update the result by shifting it by one to the left and adding the current value: num = num * 2 + head.next.val.
     * Return num.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity: O(N)\mathcal{O}(N)O(N).
     * <p>
     * Space complexity: O(1)\mathcal{O}(1)O(1).
     */
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    /**
     * Approach 2: Bit Manipulation
     * <p>
     * Initialize result number to be equal to head value: num = head.val. This operation is safe because the list is guaranteed to be non-empty.
     * <p>
     * Parse linked list starting from the head: while head.next:
     * <p>
     * The current value is head.next.val. Update the result by shifting it by one to the left and adding the current value using logical OR: num = (num << 1) | head.next.val.
     * Return num.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity: O(N)\mathcal{O}(N)O(N).
     * <p>
     * Space complexity: O(1)\mathcal{O}(1)O(1).
     */
    public int getDecimalValue2(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }


}
