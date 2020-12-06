// LeetCode 21
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode switcher = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                switcher.next = l1;
                l1 = l1.next;
            }else{
                switcher.next = l2;
                l2 = l2.next;
            }
            switcher = switcher.next;
        }
        if(l1 == null) {
            switcher.next = l2;
        }
        if(l2 == null) {
            switcher.next = l1;
        }
        switcher = switcher.next;
        return head.next;
    }
}