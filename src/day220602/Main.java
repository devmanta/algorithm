package day220602;

import java.util.Scanner;

public class Main {

//    문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
//
//        만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
//
//    추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

    public static int solution(String input){
        int answer = 0;

        for(char x : input.toCharArray()){
            if(x >=48 && x <=57){
                answer = answer * 10 + (x-48);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        String[] a = input.split(" ");
        int[] ints = solution2(a[0], a[1]);

        for(int i : ints){
            System.out.print(i + " ");
        }
    }


    ///
//    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

//    예시 입력
//    teachermode e
//    예시 출력
//    1 0 1 2 1 0 1 2 2 1 0

    public static int[] solution2(String s, String target){
        int[] answer = new int[s.length()];
        int p = 1000;

        char t = target.charAt(0);


        char[] arr = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            if(arr[i] == t){
                p=0;
            }else{
                p++;
            }
            answer[i] = p;
        }

        p = 1000;
        for(int i = s.length()-1; i >= 0; i--){
            if(arr[i] == t){
                p=0;
            }else{
                p++;
                if(answer[i] > p){
                    answer[i] = p;
                }
            }
        }


        return answer;
    }

}
