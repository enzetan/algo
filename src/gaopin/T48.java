package gaopin;

import common.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T48 {
    /*
     * 层序打印二叉树节点
     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>(); // linkedlist可以当作queue用哦
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                currAns.add(currNode.val);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            ans.add(0, currAns); // 插入到最前面（第0个）
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
