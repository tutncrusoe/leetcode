/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class _83_Remove_Duplicates_from_Sorted_List {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {


        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        head.next = second;
        second.next = third;

        System.out.println("_83_Remove_Duplicates_from_Sorted_List");
        ListNode output = deleteDuplicates(head);
        ListNode.printListNode(output);
        // output = [1, 2]
    }
}