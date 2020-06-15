package leetcode.contest2;


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/*
* 给出一个满足下述规则的二叉树：
	root.val == 0
	如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
	如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
	现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。

	请你先还原二叉树，然后实现 FindElements 类：

	FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
	bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

public class Question2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode root;

    public Question2(TreeNode root) {
        this.root = root;
        Queue<TreeNode> queue = new LinkedList();
        root.val = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int x = node.val;
            if (node.left != null) {
                node.left.val = 2 * x + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = 2 * x + 2;
                queue.offer(node.right);
            }
        }
    }

    public boolean find(int target) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int x = node.val;
            if (x == target)
                return true;
            if (node.left != null && node.left.val <= target) {
                queue.offer(node.left);
            }
            if (node.right != null && node.right.val <= target) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}
