package day221014;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

//        get1234(num);

//        getBinaryNumber(num);

//        int factorial = getFactorial(num);
//        System.out.println("factorial = " + factorial);

        for(int i = 1; i <= num; i++) {
            System.out.print(getFibonacci(i) + " ");
        }
    }


    /**
     * 재귀함수: 1 2 3 출력하는 프로그램을 작성하시오
     */
    public static void get1234(int num) {
        if(num == 0) {
            return;
        }
        get1234(num -1);
        System.out.print(num + " ");
    }


    /**
     * 재귀함수: 2진수 출력 프로그램 작성
     */
    public static void getBinaryNumber(int num) {
        if(num == 0) {
            return;
        }
        int i = num % 2;
        num = num / 2;
        getBinaryNumber(num);
        System.out.print(i);
    }

    /**
     * 재귀함수: 팩토리얼 값 구하기
     */
    public static int getFactorial(int num) {
        if(num == 1) {
            return 1;
        }

        return num * getFactorial(num - 1);
    }

    /**
     * 재귀함수: 피보나치 수열 출력
     * @return num 번째 항의 숫자
     */
    public static int getFibonacci(int num) {
        if(num == 1 || num == 2) {
            return 1;
        } else {
            return getFibonacci(num - 2) + getFibonacci(num - 1);
        }
    }

}
