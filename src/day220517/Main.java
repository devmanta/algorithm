package day220517;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static int solution(String str, char c){
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);
        for(char a : str.toCharArray()){
            if(a == c){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        char c = s.next().charAt(0);
        System.out.println(solution(input, c));
    }
}
