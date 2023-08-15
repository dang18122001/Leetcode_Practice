/*
1372. Longest ZigZag Path in a Binary Tree
You are given the root of a binary tree.
A ZigZag path for a binary tree is defined as follow:
    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
Return the longest ZigZag path contained in that tree.
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
class LongestZigZagPath {
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = new int[1];
        dfs(root.left, false, 1, result);
        dfs(root.right, true, 1, result);

        return result[0];
    }

    private void dfs(TreeNode node, boolean isRight, int length, int[] result) {
        if (node == null) {
            return;
        }

        result[0] = Math.max(result[0], length);

        if (isRight) {
            dfs(node.left, false, length + 1, result);
            dfs(node.right, true, 1, result);
        } else {
            dfs(node.right, true, length + 1, result);
            dfs(node.left, false, 1, result);
        }
    }
}