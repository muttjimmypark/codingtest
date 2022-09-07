package sheepwolf2022;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    // 처음에 혼자 생각해보고 구현해보다가 여러모로 막힘

    int[] ginfo;
    Map<Integer, TreeNode> binaryTree = new HashMap<>();
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        ginfo = info;

        //트리 초기화 + 각 노드의 양늑대 여부 생성자입력
        for (int i = 0; i < info.length; i++) {
            binaryTree.put(i, new TreeNode());
        }

        //모든 배열을 iter하여 노드간 관계 입력
        for (int[] link : edges) {
            TreeNode tmp = binaryTree.get(link[0]);
            tmp.setLeft(link[1]);
            binaryTree.put(link[0], tmp);

            tmp = binaryTree.get(link[1]);
            tmp.setMother(link[0]);
            binaryTree.put(link[1], tmp);
        }

        search(0, 0, 0);

        return answer;
    }

    private void search(int node, int sheep, int wolf) {
        if (ginfo[node] == 0) {
            sheep++;
        } else {
            wolf++;

            if (sheep <= wolf) {
                answer = Math.max(answer, sheep);
                return;
            }
        }
        thisNodeCountOver(node);


    }

    private void thisNodeCountOver(int node) {
        TreeNode tmp = binaryTree.get(node);
        tmp.sheepWolfCount = true;
        binaryTree.put(node, tmp);
    }

}

class TreeNode {
    boolean sheepWolfCount;
    int mother;
    int left;
    int right;

    public TreeNode() {
        sheepWolfCount = false;
        mother = -1;
        left = -1;
        right = -1;
    }

    public int getMother() {
        return mother;
    }

    public void setMother(int mother) {
        this.mother = mother;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        if (this.left != -1) {
            setRight(left);
        }

        this.left = left;
    }

    public int getRight() {
        return right;
    }

    private void setRight(int right) {
        this.right = right;
    }
}