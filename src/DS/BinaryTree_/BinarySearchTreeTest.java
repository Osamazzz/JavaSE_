package DS.BinaryTree_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class BinarySearchTreeTest {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //node的值应在(minVal,maxVal)中
    public boolean isValidBST(TreeNode node, long minVal, long maxVal) {
        //空结点默认返回true
        if (node == null) {
            return true;
        }
        //如果结点值大于maxVal或者小于minVal则直接返回false
        if (node.val >= maxVal || node.val <= minVal) {
            return false;
        }
        //左子树的值不能大于当前结点的值，右子树的值不能小于当前结点的值
        return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }

    TreeNode prev;//前一个节点

    public boolean isValidBST_MiddleOrderTraversal(TreeNode root) {
        if (root == null)
            return true;
        //访问左子树
        if (!isValidBST(root.left))
            return false;
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false。
        if (prev != null && prev.val >= root.val)
            return false;
        prev = root;
        //访问右子树
        if (!isValidBST(root.right))
            return false;
        return true;
    }

    //递归法
    public TreeNode searchBST1(TreeNode root, int val) {
        //已经找到叶子结点时仍未找到
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST1(root.left, val);
        } else {
            return searchBST1(root.right, val);
        }
    }

    //迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    //二叉搜索树的插入操作
    //递归
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST1(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST1(root.right, val);
        }
        //返回根节点
        return root;
    }

    TreeNode prevRoot;
    //迭代
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode res = root;
        TreeNode node = new TreeNode(val);
        while (true) {
            if (val < root.val){
                if (root.left == null){
                    root.left = node;
                    break;
                }
                root = root.left;
            }else if (val > root.val) {
                if (root.right == null) {
                    root.right = node;
                    break;
                }
                root = root.right;
            }
        }
        return res;
    }
}
