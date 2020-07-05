import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /*
    def inorder(self, root):
        if root:
            self.inorder(root.left)
            self.traverse_path.append(root.val)
            self.inorder(root.right)
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private static void inorder(TreeNode root, List<Integer> res) {
        if(root!=null) {
            if(root.left!=null) {
                inorder(root.left,res);
            }
            res.add(root.val);
            if(root.right!=null){
                inorder(root.right,res);
            }
        }
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> res=inorderTraversal(node1);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
