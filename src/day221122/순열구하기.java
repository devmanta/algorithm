package day221122;

import java.util.Scanner;

public class 순열구하기 {
    /*
    10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합 니다.

    ▣ 입력설명
        첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다. 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
    ▣ 출력설명
        첫 번째 줄에 결과를 출력합니다.
        출력순서는 사전순으로 오름차순으로 출력합니다.
    ▣ 입력예제 1 32
        369
    ▣ 출력예제 1 36
        39
        63
        69 93 96
    */
    static int n; // 숫자 몇개 받을 건지
    static int m; // 순열 크기

    static int[] arr; // 입력한 숫자
    static int[] pm; // 답출력
    static int[] ch; // 체크배열

    public static void DFS(int L){
        if(L == m) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ch = new int[n]; // 체크 배열은 arr의 크기만큼 있어야함 각각 arr이 이행됐는지 안됐는지 체크하는 거니깐
        pm = new int[m]; // 출력 하는 거는 순열 크기 몇개 출력하는지 만큼의 크기가 필요함

        DFS(0);
    }
}