package algorithms.interview.oracle;

import java.util.ArrayList;
import java.util.List;

class TreeNode{

    int val;
    List<TreeNode> children;

    TreeNode(int val){
        this.val = val;
        children = new ArrayList<>();
    }

    TreeNode(int val, List<TreeNode> children){
        this.val = val;
        this.children = children;
    }

}

public class AreTheseNaryTreesTheSame {

    public boolean areTheySame(TreeNode node1, TreeNode node2){

        if(node1 == null || node2 == null)
            return false;

        if(node1.val!=node2.val)
            return false;

        if(node1.children == null && node2.children == null)
            return true;

        if(node1.children == null || node2.children == null)
            return false;

        if(node1.children.size() != node2.children.size())
            return false;

        for(int i =0; i<node1.children.size(); i++){
            TreeNode childrenLeft = node1.children.get(i);
            TreeNode childrenRight = node2.children.get(i);
            if(!(areTheySame(childrenLeft, childrenRight)))
                return false;
        }

        return true;
    }

    public static int maxDepth(TreeNode node, int depth){

        if(node==null)
            return 0;

        depth++;

        if(node.children.size()==0)
            return depth;

        List<Integer> localDepthsList = new ArrayList<>();

        for(TreeNode n:node.children){
            localDepthsList.add(maxDepth(n, 0));
        }

        int localMaxDepth = 0;

        for(int localPathDepth:localDepthsList){
            localMaxDepth = Math.max(localMaxDepth, localPathDepth);
        }

        return depth+localMaxDepth;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node33 = new TreeNode(33);
        TreeNode node99 = new TreeNode(99);

        root1.children.add(node2);
        root1.children.add(node3);
        root1.children.add(node5);
        node2.children.add(node4);
        node2.children.add(node6);
        node3.children.add(node1);
        node3.children.add(node7);
        node3.children.add(node9);
        node7.children.add(node99);
        node5.children.add(node33);
        node1.children.add(new TreeNode(555));
        node1.children.add(new TreeNode(777));
        node1.children.add(new TreeNode(0));


        TreeNode root21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        TreeNode node25 = new TreeNode(5);
        TreeNode node24 = new TreeNode(4);
        TreeNode node26 = new TreeNode(6);
        TreeNode node21 = new TreeNode(1);
        TreeNode node27 = new TreeNode(7);
        TreeNode node29 = new TreeNode(9);
        TreeNode node233 = new TreeNode(33);
        TreeNode node299 = new TreeNode(99);
        node21.children.add(new TreeNode(555));
        node21.children.add(new TreeNode(777));
        node21.children.add(new TreeNode(0));
        node21.children.add(new TreeNode(0));
        root21.children.add(node22);
        root21.children.add(node23);
        root21.children.add(node25);
        node22.children.add(node24);
        node22.children.add(node26);
        node23.children.add(node21);
        node23.children.add(node27);
        node23.children.add(node29);
        node27.children.add(node299);
        node25.children.add(node233);
        System.out.println(new AreTheseNaryTreesTheSame().areTheySame(root1,root21));

        System.out.println(AreTheseNaryTreesTheSame.maxDepth(root1,0));
    }
}
