/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * Input: head = []
 * Output: []
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class _206_Reverse_Linked_List {

    /**
     * Three pointers
     * Approach 1: Iteratively
     * -
     * Complexity analysis
     * -
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    // Best Practice
    // 0 ms
    public static ListNode reverseList_(ListNode head) {
        ListNode res = null, next = head;

        while (next != null) {
            System.out.println(head.val);
            next = next.next;
            head.next = res;
            res = head;
            head = next;
        }
        return res;
    }

    /**
     * Approach 2: Recursive approach
     *
     * Complexity analysis
     *
     * Time complexity: O(n)
     * Space complexity: O(n) -> cost made by Recursive calls
     */
    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }
    private static ListNode reverseList(ListNode head, ListNode newHead) {
        if(head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
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
        ListNode output = reverseList(head);
        output.printListNode(output);
//        Output: [3, 4, 5, ]
    }
}
