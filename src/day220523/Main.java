package day220523;

import java.util.Scanner;

public class Main {

    public static String solution(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() -1; i >= 0; i--){
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static String solution2(String str){
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() -1;

        while(lt < rt){
            char tmp = s[lt];
            s[lt] = s[rt];
            s[rt] = tmp;
            lt++;
            rt--;
        }

        return String.valueOf(s);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        String[] result = new String[num];
        for(int i = 0; i < num; i++){
            String input = s.next();
            result[i] = solution(input);
        }

        for(String s1: result) {
            System.out.println(s1);
        }
    }

}
