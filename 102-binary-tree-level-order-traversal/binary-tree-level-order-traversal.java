class Pair{
    TreeNode r;
    int level;

    Pair(TreeNode r, int level){
        this.r = r;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        if(root == null) return list;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,1));
        int currLevel = 1;

        while(q.size() > 0){
            Pair front = q.remove();

            // if level is same
            if(currLevel == front.level){
                innerList.add(front.r.val);
            }
            /* if level changes then store innerlist in outerlist
            and innerlist ko new list sa point kr diya, currlevel also increase*/
            else{
                list.add(innerList);
                innerList = new ArrayList<>();
                innerList.add(front.r.val);
                currLevel++;
            }

            // queue mai left right child insert kr diya
            if(front.r.left != null) q.add(new Pair(front.r.left, front.level+1));
            if(front.r.right != null) q.add(new Pair(front.r.right, front.level+1));
        }

        list.add(innerList);
        return list;

    }
}