// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printListNode(ListNode head) {
        System.out.print("Output: [");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println("]");
    }
}