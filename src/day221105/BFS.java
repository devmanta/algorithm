package day221105;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    // 정점으로 가는 최소 이동 간선 수

    static int n, m; // n: 노드의 수, m: 노드A부터 노드B까지 가는 경우의 수 1-> 2, 2->3 이런거 몇개 주어지은지
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis; //ch: 방문 체크 배열, dis: 노드A부터 노드B까지 거리

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            for(int nextNode : graph.get(currentNode)) { //v = 1 일 때, 1이 갈 수 있는 모든 노드 ( 1-> 2, 1->3, 1->4 면 , [2,3,4]가 포문 돈다.
                if(ch[nextNode] == 0) {
                    ch[nextNode] = 1;
                    queue.offer(nextNode);
                    dis[nextNode] = dis[currentNode] + 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n + 1];
        dis = new int[m + 1];

        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        BFS(1);

        for(int i = 2; i <=n ; i++) {
            System.out.println("i = " + dis[i]);
        }
    }
}