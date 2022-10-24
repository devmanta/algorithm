package day221024;


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

/**
 * 이진트리 레벨탐색
 */
public class BreadthFirstSearch {

    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        int level = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(level + ": ");
            for(int i = 0; i < len; i++) {
                Node currentNode = Q.poll();

                if(currentNode != null) {
                    System.out.print(currentNode.data + " ");
                    if(currentNode.lt != null) {
                        Q.offer(currentNode.lt);
                    }

                    if(currentNode.rt != null) {
                        Q.offer(currentNode.rt);
                    }
                }
            }

            level++;
            System.out.println();
        }


    }

    public static void main(String[] args) {
        BreadthFirstSearch tree = new BreadthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.BFS(tree.root);
    }

}
