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
    //Recursion
    // public int maxDepth(TreeNode root) {
    //     if(root == null) return 0;

    //     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    // }

//Iterative
     public int maxDepth(TreeNode root) {
       Stack<Pair<TreeNode,Integer>> stack =  new Stack<>();

       stack.push(new Pair<TreeNode,Integer>(root,1));
       int res=0;

       while(!stack.isEmpty()){
        Pair<TreeNode,Integer> curr = stack.pop();
        TreeNode node = curr.getKey();
        int depth = curr.getValue();

        if(node != null){
            res =Math.max(res,depth);
            stack.push(new Pair<> (node.left,depth+1));
            stack.push(new Pair<> (node.right,depth+1));
        }

       }

       return res;

     }
}
