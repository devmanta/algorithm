package day221110;

import java.util.Scanner;

public class 중복순열 {

    /*
    중복순열 구하기

    1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다.
    ▣ 입력설명
    첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
    ▣ 출력설명
    첫 번째 줄에 결과를 출력합니다.
    출력순서는 사전순으로 오름차순으로 출력합니다.

    ▣ 입력예제
    3 2
    ▣ 출력예제
    11
    12
    13
    21
    22
    23
    31
    32
    33
    */

    static int[] pm; // 중복 순열값 넣어 놓는 변수
    static int n; // 몇번째 숫자 까지 있는지
    static int m; // 중복값 집합 의 수(?) == level 수

    public static void DFS(int L) {
        if(L == m) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();

        pm = new int[m];

        DFS(0);
    }

}
