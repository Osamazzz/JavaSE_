package DS.BinaryTree_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class DeleteNodeTest {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return delete(root, key);
    }

    /**
     * 删除，三种情况
     * 1. 目标节点没有左右子树，直接删除
     * 2. 目标节点只有左子树或只有右子树，原来指向目标节点的指针指向其左子树或右子树
     * 3. 目标节点有左右子树:
     * 方案一：找到左子树的最右节点，让原来指向这个左子树最右节点的指针指向其左子树，然后用这个左子树最右节点替换掉目标节点
     * 方案二：找到右子树的最左节点，让原来指向这个右子树最左节点的指向指向其右子树，然后用这个右子树最左节点替换掉目标节点
     *
     * @param root 根节点
     * @param key  待删除节点值
     * @return 新的根节点
     */
    private TreeNode delete(TreeNode root, int key) {
        // 找到要删除的节点
        TreeNode pre = null, deletedNode = root;
        while (deletedNode != null && deletedNode.val != key) {
            pre = deletedNode;
            if (deletedNode.val > key) {
                deletedNode = deletedNode.left;
            } else {
                deletedNode = deletedNode.right;
            }
        }
        // 找不到
        if (deletedNode == null) {
            return root;
        }
        TreeNode newNode = null;
        // 第一、第二种情况
        if (deletedNode.left == null || deletedNode.right == null) {
            if (deletedNode.left == null) {
                newNode = transplant(pre, deletedNode, deletedNode.right);
            }
            if (deletedNode.right == null) {
                newNode = transplant(pre, deletedNode, deletedNode.left);
            }
            if (pre == null) {
                return newNode;
            }
            return root;
        }
        // 第三种情况
        TreeNode minNodePre = deletedNode, minNode = deletedNode.right;
        while (minNode.left != null) {
            minNodePre = minNode;
            minNode = minNode.left;
        }
        if (minNode == deletedNode.right) {
            newNode = transplant(pre, deletedNode, minNode);
        } else {
            transplant(minNodePre, minNode, minNode.right);
            newNode = transplant(pre, deletedNode, minNode);
            newNode.right = deletedNode.right;
        }
        newNode.left = deletedNode.left;
        return pre == null ? newNode : root;
    }

    /**
     * 用 newNode 节点取代待删除节点
     *
     * @param parentNode  待删除节点的父节点
     * @param deletedNode 待删除节点
     * @param newNode     newNode
     * @return newNode
     */
    private TreeNode transplant(TreeNode parentNode, TreeNode deletedNode, TreeNode newNode) {
        if (parentNode == null) {
            return newNode;
        }
        if (parentNode.left == deletedNode) {
            parentNode.left = newNode;
        } else if (parentNode.right == deletedNode) {
            parentNode.right = newNode;
        }
        return newNode;
    }
}
