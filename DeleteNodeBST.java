/*
450. Delete Node in a BST
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
Basically, the deletion can be divided into two stages:
    Search for a node to remove.
    If the node is found, delete the node.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found
            if (root.left == null && root.right == null) {
                // Case 4a: Node is a leaf node
                return null;
            } else if (root.left == null) {
                // Case 4b: Node has only right child
                return root.right;
            } else if (root.right == null) {
                // Case 4b: Node has only left child
                return root.left;
            } else {
                // Case 4c: Node has both left and right children
                // Find the minimum value node in the right subtree (inorder successor)
                TreeNode minValueNode = findMinValueNode(root.right);
                // Copy the value of the inorder successor to the current node
                root.val = minValueNode.val;
                // Delete the inorder successor node from the right subtree
                root.right = deleteNode(root.right, minValueNode.val);
            }
        }

        return root;
    }

    private TreeNode findMinValueNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
