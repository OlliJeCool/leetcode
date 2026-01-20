package alg;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static void main() {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        pathSum(root, -5);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(root.val);
        backtrack(root, current, root.val, res, targetSum);
        res = (res.size() == 1 && res.getFirst().isEmpty()) ? new ArrayList<>() : res;
        return res;
    }


    public static void backtrack(TreeNode node, List<Integer> cur, int sum, List<List<Integer>> res, int target){
        if(sum == target && isLeaf(node)){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(isLeaf(node)) return;

        TreeNode child = node.left;
        if(child != null){
            cur.add(child.val);
            backtrack(child, cur, sum+child.val, res, target);
            cur.removeLast();
        }
        child = node.right;
        if(child != null){
            cur.add(child.val);
            backtrack(child, cur, sum+child.val, res, target);
            cur.removeLast();
        }
    }

    public static boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }
}




