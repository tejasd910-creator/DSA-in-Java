/**
 * You are given the node to be deleted node. You will not be given access to
 * the first node of head.
 * 
 * All the values of the linked list are unique, and it is guaranteed that the
 * given node node is not the last node in the linked list.
 * 
 * 
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}