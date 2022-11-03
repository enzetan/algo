package gaopin;


import common.tree.TreeNode;

public class T45 {
    /*
     * 判断是否是镜面树
     * leetcode.101
     * */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) { //异或，如果两个不同，则不是
            return false;
        }
        if (h1 == null && h2 == null) { //都为空的话是镜面
            return true;
        }
        // 值要相同，且h1的左要等于h2的右，h2的右要等于h1的左
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}