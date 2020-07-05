import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    def preorder(self, root):
        if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if(root!=null) {
            res.add(root.val);
            if(root.left!=null) {
                preorder(root.left,res);
            }
            if(root.right!=null){
                preorder(root.right,res);
            }
        }

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> res=preorderTraversal(node1);
        System.out.println(Arrays.toString(res.toArray()));

    }
}
