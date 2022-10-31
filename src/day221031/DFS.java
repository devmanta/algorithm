package day221031;

import java.util.Scanner;

public class DFS {

    /**
     방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
     1 2 3 4 5
     1 2 5
     1 3 4 2 5
     1 3 4 5
     1 4 2 5
     1 4 5
     총 6가지 입니다.

     입력설명:
     첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다.
     그 다으무터 M줄에 걸쳐 연결정보가 주어진다.

     출력설명:
     총 가지수를 출력한다.

     입력예제:
     5 9
     1 2
     1 3
     1 4
     2 1
     2 3
     2 5
     3 4
     4 2
     4 5

     출력예제:
     6
     */

    static int n, answer = 0;
    static int[][] graph;
    static int[] ch;

    public static void DFS(int v) {
        if(v == n) {
            answer++;
        } else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1 && graph[v][i] == 1) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int m = s.nextInt();

        graph = new int[n + 1][m + 1];

        ch = new int[n + 1];

        for(int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            graph[a][b] = 1;
        }
        ch[1] = 1;

        DFS(1);

        System.out.println("answer = " + answer);
    }
}
