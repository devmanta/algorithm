package day220705;

import java.util.Scanner;

public class Main {

//    소수(에라토스테네스 체) ====> 일단 배열값 0 으로 하고 0이면 소수이고 그 숫자의 배수는 1로 둠

//    설명
//
//    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
//
//        만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
//
//
//        입력
//    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
//
//
//    출력
//    첫 줄에 소수의 개수를 출력합니다.
//
//
//    예시 입력 1
//
//        20
//    예시 출력 1
//
//        8

    public static int solution(int num){
        int cnt = 0;

        int[] ch = new int[num +1];

        for(int i = 2; i <= num; i++){
            if(ch[i] == 0){
                cnt++;
                for(int j = i; j <= num; j=j+i){
                    ch[j] = 1;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        System.out.println(solution(num));
    }

}
