/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * Constraints:
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */
public class _876_Middle_of_the_Linked_List {
    /**
     * Approach 2: Fast and Slow Pointer
     * Intuition and Algorithm
     * -
     * When traversing the list with a pointer slow,
     * make another pointer fast that traverses twice as fast.
     * When fast reaches the end of the list, slow must be in the middle.
     * -
     * Complexity Analysis
     * Time Complexity: O(N), where NNN is the number of nodes in the given list.
     * Space Complexity: O(1), the space used by slow and fast.
     */
    // Best Practice
    // 0 ms
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Approach 1: Output to Array
     * Intuition and Algorithm
     * Put every node into an array A in order. Then the middle node is just A[A.length // 2], since we can retrieve each node by index.
     * We can initialize the array to be of length 100, as we're told in the problem description that the input contains between 1 and 100 nodes.
     * -
     * Complexity Analysis
     * Time Complexity: O(N), where NNN is the number of nodes in the given list.
     * Space Complexity: O(N), the space used by A.
     */
    // 0 ms
    public static ListNode middleNode2(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        head.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        ListNode.printListNode(head);
        ListNode output = middleNode(head);
        output.printListNode(output);
//        Output: [3, 4, 5, ]
    }
}
