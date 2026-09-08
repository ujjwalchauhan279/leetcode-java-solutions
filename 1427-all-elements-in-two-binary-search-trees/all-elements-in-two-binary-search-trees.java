class Solution {
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    public List<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> result = new ArrayList<>();
        int i=0; 
        int j=0;
        while(i<arr1.size() && j<arr2.size()){
            int a = arr1.get(i);
            int b = arr2.get(j);
            if(a <= b){
                result.add(a);
                i++;
            }
            else{
                result.add(b);
                j++;
            }
        }
        while(i<arr1.size()) result.add(arr1.get(i++));
        while(j<arr2.size()) result.add(arr2.get(j++));

        return result;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        inorder(root1, arr1);
        inorder(root2, arr2);

        return merge(arr1, arr2);
    }
}