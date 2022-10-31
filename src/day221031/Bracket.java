package day221031;

import java.util.Stack;

public class Bracket {

    /**
     * 괄호 대칭인지 확인하기 {}, [], () 이거 세개 있음
     */

    static char[][] TOKENS = {
        {'{', '}'},
        {'[', ']'},
        {'(', ')'}
    };

    public static boolean isOpenTerm(char c) {
        for(char[] ch: TOKENS) {
            if(ch[0] == c) {
                return true;
            }
        }

        return false;
    }

    public static boolean isMatchedBracket(char open, char close) {
        for(char[] ch: TOKENS) {
            if(ch[0] == open) {
                return ch[1] == close;
            }
        }

        return false;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c : expression.toCharArray()) {
            if(isOpenTerm(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || !isMatchedBracket(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
