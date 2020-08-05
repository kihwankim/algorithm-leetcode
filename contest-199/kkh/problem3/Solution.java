import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int countPairs(TreeNode root, int distance) {
        List<LeafNode> leafNodeList = this.makeLeafList(root);
        int numberOfPair = 0;
        for (int indexOfOutter = 0; indexOfOutter < leafNodeList.size(); ++indexOfOutter) {
            LeafNode compareLeaf = leafNodeList.get(indexOfOutter);
            for (int indexOfInnder = indexOfOutter + 1; indexOfInnder < leafNodeList.size(); ++indexOfInnder) {
                LeafNode nowLeafNode = leafNodeList.get(indexOfInnder);
                int distanceBetweenTwoNodes = this.getDistance(compareLeaf, nowLeafNode);
                if (distanceBetweenTwoNodes <= distance) {
                    numberOfPair += 1;
                }
            }
        }

        return numberOfPair;
    }

    private int getDistance(LeafNode l, LeafNode r) {
        int sameIndex = 0;

        while (sameIndex < l.leftOrRight.length() && sameIndex < r.leftOrRight.length()) {
            if (l.leftOrRight.charAt(sameIndex) != r.leftOrRight.charAt(sameIndex)) break;
            sameIndex++;
        }

        return l.leftOrRight.length() + r.leftOrRight.length() - 2 * sameIndex;
    }


    private List<LeafNode> makeLeafList(TreeNode root) {
        List<LeafNode> leafNodes = new ArrayList<>();
        Queue<LeafNode> queue = new LinkedList<>();
        queue.add(new LeafNode(root, ""));
        while (!queue.isEmpty()) {
            boolean hasChild = false;
            LeafNode now = queue.poll();
            TreeNode nowTreeNode = now.root;
            if (nowTreeNode.left != null) {
                queue.add(new LeafNode(nowTreeNode.left, now.leftOrRight + "0"));
                hasChild = true;
            }
            if (nowTreeNode.right != null) {
                queue.add(new LeafNode(nowTreeNode.right, now.leftOrRight + "1"));
                hasChild = true;
            }

            if (!hasChild) {
                leafNodes.add(now);
            }
        }
        return leafNodes;
    }

    class LeafNode {
        TreeNode root;
        String leftOrRight;

        public LeafNode(TreeNode root, String leftOrRight) {
            this.root = root;
            this.leftOrRight = leftOrRight;
        }
    }
}