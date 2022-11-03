package gaopin;

import common.tree.TreeNode;

import java.util.HashMap;

public class T47 {
    /*
     * 用先序遍历和中序遍历的结果重构一棵树
     * 先序的第一个一定是头，在中序遍历中找到这个元素，则可以区分左树和右树
     *
     * leetcode.
     * */

    public static TreeNode buildTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;// 过滤条件
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    // 建出整个树然后返回头节点
    public static TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if (l1 > l2) { // 遇到空树
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]); // 建立头节点
        if (l1 == l2) {
            return new TreeNode(pre[l1]);
        }
        /*
         * 优化点: 每次都是遍历的，可以打成一张表
         * */
        int find = l2;
        for (; in[find] != pre[l1]; find++) ;// 找到中序中等于先序第一个的元素位置
        // 左数: pre[l1+1, l1+find-l2]
        head.left = f(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
        head.right = f(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
        return head;
    }

    // 优化: 时间复杂度O(n)
    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;// 过滤条件
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i); //记录中序遍历的每个值在哪里
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    public static TreeNode g(int[] pre, int l1, int r1, int[] in, int l2, int r2,
                             HashMap<Integer, Integer> valueIndexMap) {
        if (l1 > l2) { // 遇到空树
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]); // 建立头节点
        if (l1 == l2) {
            return new TreeNode(pre[l1]);
        }
        int find = valueIndexMap.get(pre[l1]);// 找到中序中等于先序第一个的元素位置(空间换时间)
        // 左数: pre[l1+1, l1+find-l2]
        head.left = f(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
        head.right = f(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
        return head;
    }

    public static void main(String[] args) {

    }
}
