package day221122;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    /*
    5. 동전교환
    설명
    다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    각 단위의 동전은 무한정 쓸 수 있다.

    입력
    첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
    그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.

    출력
    첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

    예시 입력 1
        3
        1 2 5
        15
    예시 출력 1
        3
    */

    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    public static void solution(int L, int sum, Integer[] arr) {
        if(sum > m) { //m이 거슬러줘야하는 총 금액인데, 총합친 값(sum)이 m보다 크면 더 뻗어나갈 필요가 없음
            return;
        }

        if(L >= answer) { //레벨이 우리가 구하고자 하는 최소 개수보다 크면은 의미가 없음. 정답이 절대 될 수가 없다. 그래서 더 뻗어나갈 필요가 없다.
            return;
        }

        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < n; i++) {
                solution(L + 1, sum + arr[i], arr);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 동전의 개수
        Integer[] arr = new Integer[n]; // 동전의 종류
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt(); // 거스름 줘야하는 총 금액

        Arrays.sort(arr, Collections.reverseOrder()); // 처음 뻗어 나갈 때, 큰 숫자부터 sum쳐서 최소값 구하면 시간복잡도가 줄어든다.

        solution(0, 0, arr);
        System.out.println(answer);
    }

}
