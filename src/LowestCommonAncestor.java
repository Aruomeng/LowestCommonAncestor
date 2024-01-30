/**
 * @Author:田宇航
 * @Date: 2024/1/30 17:08
 */
// 定义二叉树节点
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class LowestCommonAncestor {
    // 在二叉树中找到两个节点的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为null或者等于其中一个目标节点，直接返回根节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 在左子树中查找最近公共祖先
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        // 在右子树中查找最近公共祖先
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树分别包含p和q，则当前根节点即为最近公共祖先
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // 如果只有左子树包含p或q，或者只有右子树包含p或q，则返回对应的最近公共祖先
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        // 创建一棵二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();

        // 测试两个节点的最近公共祖先
        TreeNode p = root.left;  // 例如，节点5
        TreeNode q = root.right; // 例如，节点1

        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        System.out.println("The Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        System.out.println("没错你做到了");
        System.out.println("没错你做到了");

    }
}


