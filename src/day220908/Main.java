package day220908;

import java.util.Scanner;

public class Main {

    /*
    5. 연속된 자연수의 합
        설명

    N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

    만약 N=15이면
    7+8=15
    4+5+6=15
    1+2+3+4+5=15
    와 같이 총 3가지의 경우가 존재한다.

        입력
    첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

    출력
    첫 줄에 총 경우수를 출력합니다.


    예시 입력 1
        15
    예시 출력 1
        3
    */

    public static int solution(int sum) {
        int answer = 0;

        int num = sum / 2 + 1; //합을 구하는 거여서 중간 값보다 1 큰 숫자 까지만 더하면 됨
        int[] arr = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = i + 1;
        }

        int lt = 0;
        int sumArr = 0;
        for(int rt = 0; rt < num; rt++) {
            sumArr += arr[rt];
            if(sumArr == sum) {
                answer++;
            }

            while(sumArr >= sum) {
                sumArr -= arr[lt];
                lt++;
                if(sumArr == sum) {
                    answer++;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = s.nextInt();
        System.out.println(solution(sum));
    }


    //수학적 방법
    public static int solutionAsMath(int num) {
        int answer = 0;
        int cnt = 1;
        num--;

        while(num > 0) {
            num -= cnt;
            cnt++;

            if(num % cnt ==0) {
                answer++;
            }
        }

        return answer;
    }

}
