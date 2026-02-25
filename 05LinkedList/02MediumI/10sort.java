//Definition for singly-linked list.
class ListNode {
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
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 1st Half
        ListNode mid = mid(head);
        //2nd Half
        ListNode headTwo = mid.next;
        mid.next = null;

        //sort 1st part
        head = sortList(head);
        //sort 2nd part
        headTwo = sortList(headTwo);

        //merging
        return merge(head, headTwo);
    }

    private ListNode mid(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;       // so that mid not fail for even list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head, ListNode headTwo) {
        if (head.val > headTwo.val) {
            ListNode temp = head;
            head = headTwo;
            headTwo = temp;
        }
        ListNode prev = null, newHead = head;
        while (head != null && headTwo != null) {
            if (head.val <= headTwo.val) {
                prev = head;
                head = head.next;
            } else {
                ListNode temp = headTwo.next;
                if(prev != null){
                    prev.next = headTwo;
                }
                prev = headTwo;
                headTwo.next = head;
                headTwo = temp;
            }
        }
        if (headTwo != null) {
            prev.next = headTwo;
        }

        return newHead;
    }
}