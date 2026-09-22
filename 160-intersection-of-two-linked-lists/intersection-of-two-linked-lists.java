public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int lenA = 0;
        int lenB = 0;

        while(t1 != null){
            lenA++;
            t1 = t1.next;
        }
        while(t2 != null){
            lenB++;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;

        if(lenA > lenB){
            for(int i=1; i<= lenA - lenB; i++){
                t1 = t1.next;
            }
        }
        else{
            for(int i=1; i<= lenB - lenA; i++){
                t2 = t2.next;
            }
        }


        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        if(t1 == t2) return t1;
        else return null;
    }
}