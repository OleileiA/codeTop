
// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.TreeMap;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
