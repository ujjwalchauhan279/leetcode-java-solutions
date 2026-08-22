class Pair{
    TreeNode r;
    int level;

    Pair(TreeNode r, int level){
        this.r = r;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        if(root == null) return list;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 1));
        int currLevel = 1; 

        while(q.size() > 0){
            Pair front = q.remove();

            if(currLevel == front.level){
                innerList.add(front.r.val);
            }

            else{
                list.add(innerList);
                innerList = new ArrayList<>();
                innerList.add(front.r.val);
                currLevel++;
            }

            if(front.r.left != null) q.add(new Pair(front.r.left, front.level+1));
            if(front.r.right != null) q.add(new Pair(front.r.right, front.level+1));
        }

        list.add(innerList);
        Collections.reverse(list);
        return list;
    
    }
}