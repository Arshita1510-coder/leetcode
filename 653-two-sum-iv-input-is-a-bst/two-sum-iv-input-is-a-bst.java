/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution{
    void inorder(TreeNode root,List<Integer>result){
        if(root==null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
    public boolean findTarget(TreeNode root,int k){
        List<Integer>list=new ArrayList<>();
        inorder(root,list);
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==k){
                    return true;
                }
            }
        }
        return false;
    }
 }
 