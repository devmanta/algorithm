package day220918;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
/*
    2. 괄호문자제거
        설명
    입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

    입력
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

    출력
    남은 문자만 출력한다.

    예시 입력 1
        (A(BC)D)EF(G(H)(IJ)K)LM(N)
    예시 출력 1

    EFLM
*/

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                stack.pop();
            } else {
                if(stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(solution(str));
    }

    public static String solutionFromClass(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '('); // ( 까지 스택에 쌓여 있는 것들을 빼낸다.
            } else {
                stack.push(c);
            }
        }

        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

//        for(char c : stack) { // 이것도 가능 근데 위에서 size랑 get 사용할 수 있다는 걸 보여주기 위함
//            answer += stack.get(i);
//        }

        return answer;
    }

}
