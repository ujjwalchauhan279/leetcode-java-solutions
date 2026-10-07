class Solution {
    public int size(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        return len;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd = head;

        while(curr != null){
            fwd = fwd.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int size = size(head);
        ListNode newHead = reverse(head);
        int arr[] = new int[size];
        int i = size - 1;
        ListNode temp = newHead;

        while(temp != null){
            while(st.size() > 0 && temp.val >= st.peek()) st.pop();

            if(st.size() == 0){
                arr[i] = 0;
            }
            else{
                arr[i] = st.peek();
            }
            st.push(temp.val);
            i--;
            temp = temp.next; 
        }

        return arr;
        
    }
}