package day220530;

import java.util.Scanner;

public class Main {

    public static String solution(String input){
        char[] chars = input.toCharArray();

        int lt = 0;
        int rt = input.length()-1;

        while(lt < rt){
            if( (chars[lt] >= 65 && chars[lt] <=90 ) || (chars[lt] >=97 && chars[lt] <=122 )){
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
            }

            lt++;
            rt--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(solution(input));
    }

}
