package gaopin;

import common.tree.TreeNode;

public class T49T50 {
    /*
     * 判断一棵树是否是搜索二叉树
     *  中序遍历是递增的二叉树一定是搜索二叉树
     *  递归解法:
     *    每个节点需要返回三个信息:
     *      1. 是不是搜索二叉树
     *      2. 最小值是多少
     *      3. 最大值是多少
     * */
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int max, int min) {
            isBST = is;
            this.max = max;
            this.min = min;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) isBST = false;
        if (rightInfo != null && !rightInfo.isBST) isBST = false;

        // left Max < x         right Min > x
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
        if (!leftMaxLessX || !rightMinMoreX) isBST = false;
        return new Info(isBST, max, min);
    }

    public static void main(String[] args) {

    }
}
