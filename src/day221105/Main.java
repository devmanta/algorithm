package day221105;

import java.util.Scanner;

public class Main {

    /*
    1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
    설명
    N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
    두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
    둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
    예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.

    입력
    첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
    두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.

    출력
    첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.

    예시 입력 1
        6
        1 3 5 6 7 10
    예시 출력 1
        YES
    */

    static String answer = "NO";
    static int n, total = 0; //n: 집합의 수
    static boolean flag = false; // 정답 요건에 부합하는지 여부

    public static void DFS(int L, int sum, int[] arr) {
        if(flag) {
            return; // 정답 요건에 부합했으니깐 더이상 뻗어나가지 않아도 됨
        }

        if(sum > total / 2) {
            return; // 합이 집합 전체의 합/2 보다 크면은 어차피 정답 요건에 부합하지 않음
        }

        if(L == n) { // 트리 뻗어 나가다가, n번째가 되면 이제 확인 해야함 (노드의 수가 끝이니까, 다 뻗어 나간 거임 마지막인 것임)
            if(total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L], arr); // 자식 노드 '합'에 포함한다
            DFS(L + 1, sum, arr); // 자식 노드 '합'에 포함하지 않는다
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(0, 0, arr);
        System.out.println(answer);
    }

}
