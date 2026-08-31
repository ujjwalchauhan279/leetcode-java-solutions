class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode fwd = head.next.next;

        int firstIdx = -1;
        int prevIdx = -1;
        int i = 1;
        int minDistance = Integer.MAX_VALUE;

        if(fwd == null) return ans;

        while(fwd != null){
            if((prev.val > curr.val && curr.val < fwd.val) || 
            (prev.val < curr.val && curr.val > fwd.val)){
                if(firstIdx == -1){
                    firstIdx = i;
                }
                if(prevIdx != -1) minDistance = Math.min(minDistance, i-prevIdx);
                prevIdx = i;
            }

            prev = curr;
            curr = fwd;
            fwd = fwd.next;
            i++;
        }

        if(prevIdx == firstIdx) return ans;

        ans[0] = minDistance;
        ans[1] = prevIdx - firstIdx;

        return ans;
    }
}