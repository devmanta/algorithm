package day221026;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}

public class ShortestDistanceBFS {

    /**
     * 루트노드에서 말단노드까지 길이 중 가장 짧은 길이
     *
     *          1
     *      2       3
     *    4   5
     *  이렇게 트리가 되어 있으면 정답은 2! (3번이 가장 짧은 경로, level의 최소값!)
     */

    Node root;

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Node currentNode = Q.poll();

                if(currentNode.lt == null && currentNode.rt == null) {
                    return level;
                }

                if(currentNode.lt != null) {
                    Q.offer(currentNode.lt);
                }

                if(currentNode.rt != null) {
                    Q.offer(currentNode.rt);
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        ShortestDistanceBFS tree = new ShortestDistanceBFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        int bfs = tree.BFS(tree.root);
        System.out.println("bfs = " + bfs);
    }

}
