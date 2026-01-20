package alg;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        binaryTreePaths(root);
    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        backtrack(root, sb, res);
        return res;
    }

    public static void backtrack(TreeNode node, StringBuilder current, List<String> res){
        if(isLeaf(node)){
            res.add(current.toString());
            return;
        }

        TreeNode child = node.left;
        int index = current.length();
        if(child != null){
            current.append("->");
            current.append(child.val);
            backtrack(child, current, res);
            current.delete(index, current.length());
        }
        child = node.right;
        if(child != null){
            current.append("->");
            current.append(child.val);
            backtrack(child, current, res);
            current.delete(index, current.length());
        }
    }

    public static boolean isLeaf(TreeNode node){
         return (node.left == null && node.right == null);
    }

}
