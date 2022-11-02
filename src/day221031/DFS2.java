package day221031;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS2 {

    /**
     [경로탐색 인접리스트 - ArrayList 활용]
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



    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch; // 길이 있는지 없는지 확인하는 체크 배열

    public static void DFS(int v) {
        if(v == n) {
            answer++;
        } else {
            for(int nextV : graph.get(v)) {
                if(ch[v] == 0) { // 방문 안한 노드만 확인
                    ch[nextV] = 1; // 방문 이제 했으니까 방문 했다고 1로 체크
                    DFS(nextV); // 방문한 노드 이제 하위로 쭉쭉 뻗어 나가기
                    ch[nextV] = 0; // 방문다하고 되돌아 갈때 체크 해지하고 가야지 그 돌아간 노드에서 다시 DFS함수 호출로 뻗어 나갈때 경로 갈 수 있는지 확인 할 수 있음
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드의 수
        m = sc.nextInt(); // 경로의 수

        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) { // 주의 !! n 까지 생성해줘야함 0번 index는 버리는 느낌 (노드 숫자 값이 index가 된다)
            graph.add(new ArrayList<>());
        }

        ch = new int[n + 1];

        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        ch[1] = 1;
        DFS(1);

        System.out.println("answer = " + answer);
    }

}
