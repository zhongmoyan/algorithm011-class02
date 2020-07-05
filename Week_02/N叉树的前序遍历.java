import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    def preorder(self, root):
        if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res=new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        if(root!=null){
            res.add(root.val);
            for(Node node:root.children){
                preorder(node,res);
            }
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args){

    }
}
