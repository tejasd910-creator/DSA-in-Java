
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
    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        ListNode pA = l1;
        ListNode pB = l2;
        ListNode prev = pB;

        int n = 0;
        while (pA != null || pB != null) {
            int data = 0;
            if (pA == null) {
                n = pB.val + n;
            } else if (pB == null) {
                n = pA.val + n;
            } else {
                n = pA.val + pB.val + n;
            }
            data = n % 10;
            n /= 10;

            if (pB != null) {
                pB.val = data;
                prev = pB;
                pB = pB.next;
            } else {
                prev.next = pA;
                prev = pA;
                prev.val = data;
            }
            if (pA != null) {
                pA = pA.next;
            }
        }
        if (n != 0)
            prev.next = new ListNode(n);

        return l2;
    }
}