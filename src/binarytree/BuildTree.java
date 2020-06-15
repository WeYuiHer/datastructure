package binarytree;

public class BuildTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int n = pre.length;
        return build(pre, in, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] pre, int[] in, int st1, int end1, int st2, int end2) {
        if (st1 > end1) return null;
        int x = pre[st1];
        TreeNode node = new TreeNode(pre[st1]);
        int i = st2;
        for (; i <= end2; i++) {
            if (in[i] == x)
                break;
        }
        int k = i - st2;
        node.left = build(pre, in, st1 + 1, st1 + k, st2, i - 1);
        node.right = build(pre, in, st1 + k + 1, end1, i + 1, end2);

        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 6, 3, 7};
        int[] in = {5, 4, 6, 2, 1, 3, 7};
        BuildTree buildTree = new BuildTree();
        TreeNode root = buildTree.reConstructBinaryTree(pre, in);
        BinaryTree tree = new BinaryTree();
        tree.levelOrder(root);
    }

}
