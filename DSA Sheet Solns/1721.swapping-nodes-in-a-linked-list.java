/*
 * @lc app=leetcode id=1721 lang=java
 *
 * [1721] Swapping Nodes in a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode prev1 = head;
        ListNode prev2 = null;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode temp = head;
        int i=1,size=1;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        if (size == 0){
            return null;
        }
        if (k==((size+1)/2)){
            return head;
        }
        if (size==2){
            node1=head;
            node2=head.next;
            node2.next=node1;
            node1.next=null;
            head=node2;
            return head;
        }
        if (k==1){
            i=1;
            while (i<(size-2)){
                temp=temp.next;
                i++;
            }
            prev2=temp;
            node2=prev2.next;
            prev1=null;
            node1 = head;
            node2.next=node1.next;
            prev2.next=node1;
            head=node2;
            node1.next=null;
            return head;

        }
        temp=head;
        while (i<(k-1)){
            temp=temp.next;
            i++;
        }
        prev1=temp;
        node1=prev1.next;
        temp=head;
        i=1;
        while (i<(size-k-1)){
            temp=temp.next;
            i++;
        }
        prev2=temp;
        node2=prev2.next;
        if (node1.next==node2){
            prev1.next=node2;
            node1.next=node2.next;
            node2.next=prev2;
            return head;
        }
        //swapping
        temp=node1.next;
        prev1.next=node2;
        node1.next=node2.next;
        node2.next=temp;
        prev2.next=node1;
        return head;
    }
}
// @lc code=end

