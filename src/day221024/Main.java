package day221024;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    /*
    8. 송아지 찾기 1(BFS : 상태트리탐색)
    설명
        현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
        현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
        송아지는 움직이지 않고 제자리에 있다.
        현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
        최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

    입력
        첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.

    출력
        점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.

    예시 입력
        5 14
    예시 출력
        3
     */

    public static int BFS(int start, int end) {
        int[] distance = {1, -1, 5};
        int[] ch = new int[10001]; // 방문했던 노드값은 다시 방문하지 않기 위해 체크하는 배열 (index값 + 1 = 노드값) -> 만약에 내가 5번을 방문 했다, 그러면 ch[5] = 1 로 하고, 6번을 방문하지 않았으면 ch[6] = 0 이런식으로 한다.

        Queue<Integer> Q = new LinkedList<>();

        int level = 0;
        ch[start] = 1;

        Q.offer(start);

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Integer currentNode = Q.poll();
                for(int d : distance) {
                    int nextNodeValue = currentNode + d;

                    if(nextNodeValue == end) { // 다음 노드가 찾는 값이 나오면 현재 level에서 + 1 해주면 그게 정답이다.
                        return level + 1;
                    }

                    if(nextNodeValue >=1 && nextNodeValue <= 10000 && ch[nextNodeValue] == 0) { // 문제에서 1부터 10000까지라고 주어짐
                        ch[nextNodeValue] = 1;
                        Q.offer(nextNodeValue);
                    }
                }
            }
            level++;
        }

        return 0;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int end = s.nextInt();
        System.out.println(BFS(start, end));
    }

}
