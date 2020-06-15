package binarytree;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode() {
    }
}

public class BinaryTree {
    Scanner sc = new Scanner(System.in);

    //根据前序序列构建二叉树
    public TreeNode createTree() {
        int x = sc.nextInt();
        if (x == -1)
            return null;
        TreeNode node = new TreeNode(x);
        node.left = createTree();
        node.right = createTree();
        return node;
    }

    //根据括号表示法来构建二叉树     1(2(,4),3(5(6,7),))
    public TreeNode createTree2(String str) {
        int index = 0;
        char ch;
        Stack<TreeNode> stk = new Stack<>();
        int isLeft = 1; //下个节点是左孩子节点
        TreeNode node = null;
        while (index < str.length()) {
            ch = str.charAt(index);
            if (ch >= '0' && ch <= '9') {
                int i = index;
                StringBuilder sb = new StringBuilder();
                while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    sb.append(str.charAt(i) - '0');
                    i++;
                    index++;
                }
                index--;
                node = new TreeNode(Integer.parseInt(sb.toString()));
                if (stk.isEmpty()) {
                    stk.push(node);
                } else {
                    if (isLeft == 1) {
                        stk.peek().left = node;
                        isLeft = 0;
                    } else {
                        stk.peek().right = node;
                    }
                }
            } else if (ch == '(') {
                isLeft = 1;
                stk.push(node);
            } else if (ch == ',') {
                isLeft = 0;
            } else if (ch == ')')
                stk.pop();
            index++;
        }
        return stk.pop();
    }


    //前序遍历
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stk = new Stack<>();
        do {
            while (root != null) {
                list.add(root.val);
                stk.push(root);
                root = root.left;
            }
            if (stk.isEmpty())
                return list;
            else {
                root = stk.pop().right;
            }

        } while (!stk.isEmpty() || root != null);

        return list;
    }


    public void preOrder2(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        while (true) {
            while (p != null) {
                System.out.print(p.val);
                stk.push(p);
                p = p.left;
            }
            if (!stk.empty()) {
                p = stk.pop();
                p = p.right;
            } else
                break;
        }
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "  ");
            inOrder(root.right);
        }
    }

    public void inOrder2(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node;
        while (true) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            if (!stk.isEmpty()) {
                node = stk.pop();
                System.out.print(node.val);
                root = node.right;

            } else
                break;
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val);
        }
    }

    public void postOrder2(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = null, pre = null;
        do {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            pre = null;
            boolean f = true;
            while (!stk.isEmpty() && f) {
                node = stk.peek();
                if (node.right == pre) {
                    System.out.print(node.val);
                    stk.pop();
                    pre = node;
                } else {
                    root = node.right;
                    f = false;
                }
            }
        } while (!stk.isEmpty());
    }

    public void postOrder3(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode p = root;
        do {
            while (p != null) {
                stk.push(p);
                p = p.left;
            }
            TreeNode pre = null;
            while (!stk.isEmpty()) {
                TreeNode q = stk.peek();
                if (q.right == pre) {
                    System.out.print(q.val + " ");
                    stk.pop();
                    pre = q;
                } else {
                    p = q.right;
                    break;
                }
            }
        } while (!stk.isEmpty());

    }


    //层序遍历二叉树
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    //求二叉树的高度
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //括号表示法输出二叉树
    public void dispTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            if (root.left != null || root.right != null) {
                System.out.print("(");
                dispTree(root.left);
                //if(root.right!=null)
                System.out.print(",");
                dispTree(root.right);
                System.out.print(")");
            }
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode pre = null;
        do {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            if (!stk.isEmpty()) {
                TreeNode node = stk.pop();
                if (pre != null && node.val <= pre.val) {
                    return false;
                }
                pre = node;
                root = node.right;
            }
        } while (root != null || !stk.isEmpty());
        return true;
    }

    /*
     *给定一个二叉树，返回其节点值的锯齿形层次遍历。
     * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stk = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        Stack<TreeNode> curStak = null;
        stk.push(root);
        boolean leftToRight = true;
        while (!stk.isEmpty() || !stk2.isEmpty()) {

            if (leftToRight) {
                curStak = stk;
            } else
                curStak = stk2;
            int cnt = curStak.size();

            TreeNode node;
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                node = curStak.pop();
                l.add(node.val);
                System.out.print(node.val + "  ");
                if (leftToRight) {
                    if (node.left != null)
                        stk2.push(node.left);
                    if (node.right != null)
                        stk2.push(node.right);
                } else {
                    if (node.right != null)
                        stk.push(node.right);
                    if (node.left != null)
                        stk.push(node.left);
                }
            }
            System.out.println();
            list.add(l);
            leftToRight = !leftToRight;
        }

        return list;
    }

    /*
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        //	Stack<List<Integer>> stk = new Stack<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                node = queue.poll();
                l.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            //stk.push(l);
            list.add(0, l);
        }
	/*	while (!stk.isEmpty())
			list.add(stk.pop());*/
        return list;
    }

    /*
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int val = root.val;
        if (root.left == null && root.right == null)
            return sum == val;
        return hasPathSum(root.left, sum - val) || hasPathSum(root.right, sum - val);
    }

    /*
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     * 采用后序遍历
     * */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<TreeNode> stk = new LinkedList<>();
        int rest = sum;
        TreeNode pre = null;
        do {
            while (root != null) {
                stk.add(root);
                rest -= root.val;
                root = root.left;
            }
            pre = null;
            boolean f = true;
            while (!stk.isEmpty() && f) {
                root = stk.get(stk.size() - 1);
                if (root.left == null && root.right == null) {     //为叶子节点,直接出栈
                    pre = stk.remove(stk.size() - 1);
                    System.out.print(pre.val + "  ");
                    if (rest == 0) {
                        List<Integer> l = new ArrayList<>();
                        for (int i = 0; i < stk.size(); i++) {
                            l.add(stk.get(i).val);
                        }
                        l.add(pre.val);
                        list.add(l);
                    }
                    rest += pre.val;
                    root = null;
                } else {
                    if (root.right == pre || root.right == null) {
                        pre = stk.remove(stk.size() - 1);
                        System.out.print(pre.val + "  ");
                        rest += pre.val;
                        //root = stk.remove(stk.size()-1);
                    } else {
                        root = root.right;
                        f = false;
                    }
                }
            }
        } while (!stk.isEmpty());
        return list;
    }

    /*
     *  后序遍历
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode pre = null;

        do {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            boolean f = true;
            pre = null;
            while (!stk.isEmpty() && f) {
                root = stk.peek();
                if (root.right == pre) {
                    pre = stk.pop();
                    list.add(pre.val);
                } else {
                    root = root.right;
                    f = false;
                }
            }
        } while (!stk.isEmpty());


        return list;
    }

    /*
    * 根据一棵树的前序遍历与中序遍历构造二叉树。
        注意:
        你可以假设树中没有重复的元素。
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int st1, int end1, int[] inorder, int st2, int end2) {
        if (st1 > end1)
            return null;
        int val = preorder[st1];
        TreeNode node = new TreeNode(val);
        int i = st2;
        for (i = st2; i <= end2; i++) {
            if (val == inorder[i])
                break;
        }
        int k = i - st2;
        node.left = buildTreeHelper(preorder, st1 + 1, st1 + k, inorder, st2, i - 1);
        node.right = buildTreeHelper(preorder, st1 + k + 1, end1, inorder, st2 + k + 1, end2);
        return node;
    }

    /*
    * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
    例如，从根到叶子节点路径 1->2->3 代表数字 123。
    计算从根到叶子节点生成的所有数字之和。
    * */
    public int sumNumbers(TreeNode root) {
        TreeNode[] stk = new TreeNode[1000];
        int top = -1;
        TreeNode p = root;
        int ans = 0;
        do {
            while (root != null) {
                stk[++top] = root;
                root = root.left;
            }
            boolean f = true;
            TreeNode pre = null;
            while (top > -1 && f) {
                p = stk[top];
                if (p.right == pre) {
                    if (p.left == null && p.right == null) {   //  为叶子节点
                        int sum = 0;
                        for (int i = 0; i <= top; i++)
                            sum = sum * 10 + stk[i].val;
                        ans += sum;
                    }
                    top--;
                    pre = p;
                } else {
                    f = false;
                    root = p.right;
                }
            }
        } while (top != -1);
        return ans;
    }

    /*
     * 输入一颗二叉树的跟节点和一个整数，
     * 打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        TreeNode[] stk = new TreeNode[10000];
        int top = -1;
        do {
            while (root != null) {
                stk[++top] = root;
                root = root.left;
            }
            boolean f = true;
            TreeNode pre = null;
            while (top > -1 && f) {
                root = stk[top];
                if (pre == root.right) {
                    if (root.left == null && root.right == null) {
                        ArrayList<Integer> l = new ArrayList<>();
                        int i = 0;
                        int sum = 0;
                        while (i <= top) {
                            l.add(stk[i].val);
                            sum += stk[i].val;
                            i++;
                        }
                        if (sum == target) {
                            list.add(l);
                        }
                    }
                    top--;
                    pre = root;
                } else {
                    f = false;
                    root = root.right;
                }

            }
        } while (top > -1);
        return list;
    }


    /*
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int st, int end) {
        if (st > end) return null;
        int mid = st + (end - st) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, st, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }

    /*
    * 给定一个二叉树，判断它是否是高度平衡的二叉树。
    本题中，一棵高度平衡二叉树定义为：
    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    * */
    boolean f = true;

    public boolean isBalanced(TreeNode root) {
        getHeight2(root);
        return f;
    }

    public int getHeight2(TreeNode root) {
        if (root == null)
            return 0;
        int l = getHeight2(root.left) + 1;
        int r = getHeight2(root.right) + 1;
        if (Math.abs(l - r) > 1)
            f = false;
        return Math.max(l, r);
    }

    /*
     * 二叉树的最小深度
     * */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        TreeNode node;
        while (!queue.isEmpty()) {
            int x = queue.size();
            depth++;
            for (int i = 0; i < x; i++) {
                node = queue.poll();
                if (node.right == null && node.left == null)
                    return depth;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return depth;
    }

    /*
     * 在二叉搜索树中插入一个值
     * */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;
        TreeNode pre = null, p = root;
        Boolean isLchild = false;
        while (p != null) {
            pre = p;
            if (p.val < val) {
                p = p.right;
                isLchild = false;
            } else {
                p = p.left;
                isLchild = true;
            }
        }
        if (isLchild)
            pre.left = node;
        else
            pre.right = node;
        return root;
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.right = l;
        root.left = r;
        return root;
    }

    //给出一个完全二叉树，求出该树的节点个数
    public int countNodes(TreeNode root) {
        int cnt = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            cnt++;
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            else
                break;
        }
        return cnt + queue.size();
    }

    /*
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * */
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode h = null, r = null, p = pRootOfTree;
        Stack<TreeNode> stk = new Stack();
        do {
            while (p != null) {
                stk.push(p);
                p = p.left;
            }
            if (!stk.isEmpty()) {
                TreeNode node = stk.pop();
                p = node.right;
                if (h == null) {
                    h = node;
                    r = node;
                } else {

                    r.right = node;
                    node.left = r;
                    r = node;
                }

                // 打印链表信息：
//				System.out.print(" val = "+r.val );
//				if(r.left!=null)
//					System.out.print("  left = "+r.left.val);
//				if(r.right!=null)
//					System.out.print("  right = "+r.right.val);
//				System.out.println();
            }

        } while (!stk.isEmpty() || p != null);
        return h;
    }

    public void conovertPrint(TreeNode root) {
        System.out.println("left to right :");
        TreeNode p = root, r = null;
        while (p != null) {
            System.out.print("  " + p.val);
            r = p;
            p = p.right;
        }
        System.out.println();
        System.out.println("right to left :");
        p = r;
        while (p != null) {
            System.out.print("  " + p.val);
            p = p.left;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean first = true;
        boolean f = false;
        while (!queue.isEmpty() && (f || first)) {
            int k = queue.size();
            first = false;
            f = false;
            for (int j = 0; j < k; j++) {
                TreeNode node = queue.poll();
                if (node == null)
                    sb.append("null,");
                else {
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                    if (node.left != null || node.right != null)
                        f = true;
                }
            }
        }
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data == null || data.length() < 1)
            return null;
        String[] strs = data.split(",");
        if (strs[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < strs.length) {
            int k = queue.size();
            for (int j = 0; j < k; j++) {
                TreeNode node = queue.poll();
                String s = strs[i++];
                if ("null".equals(s))
                    node.left = null;
                else {
                    TreeNode left = new TreeNode(Integer.parseInt(s));
                    node.left = left;
                    queue.offer(left);
                }
                s = strs[i++];
                if ("null".equals(s))
                    node.right = null;
                else {
                    TreeNode right = new TreeNode(Integer.parseInt(s));
                    node.right = right;
                    queue.offer(right);
                }
            }
        }
        return root;

    }

    public static void main(String[] args) {
//		BinaryTree bt = new BinaryTree();
//		TreeNode root = bt.deserialize("[1,2,3,null,null,4,5]");
//		String serialize = bt.serialize(root);
//		System.out.println(serialize);


    }

}
