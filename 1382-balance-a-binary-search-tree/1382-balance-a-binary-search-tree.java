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
class Solution {
    private List<Integer>list=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildBST(0,list.size()-1);
        

        
    }
    private void inorder(TreeNode node){
        if(node==null) return ;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
    private TreeNode buildBST(int left,int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(list.get(mid));
        node.left=buildBST(left,mid-1);
        node.right=buildBST(mid+1,right);
        return node;
    }
}