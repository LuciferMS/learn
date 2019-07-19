package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @program: learn
 * @description: Solution513 广度优先遍历1
 * @author: Elliot
 * @create: 2019-07-18 15:04
 * 寻找二叉树最左边叶子节点的值，使用广度优先遍历
 **/
public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        /**
         * 这里使用LinkedList，是因为他是链表结构，删除头部节点时间效率比较低....
         */
        LinkedList<TreeNode> mark = new LinkedList<>();
        mark.add(root);
        int result = root.val;
        while (!mark.isEmpty()) {
            int size = mark.size();
            result = mark.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = mark.poll();
                if (node.left != null) {
                    mark.add(node.left);
                }
                if (node.right != null) {
                    mark.add(node.right);
                }
            }
        }
        return result;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
