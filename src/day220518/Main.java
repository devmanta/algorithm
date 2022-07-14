package day220518;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public String solution(String str){
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        for(char c : chars){
            if(c >= 97 && c <= 122){
                sb.append((char)(c - 32));
            }else{
                sb.append((char)(c + 32));
            }
        }

        return sb.toString();
    }

    public String solution2(String str){
        String result = "";
        String[] split = str.split(" ");
        for(String s : split){
            if (result.length() < s.length()){
                result = s;
            }
        }

        return result;
    }

    public String solution2_1(String str){
        String result = "";

        int index = 0;
        while( (index = str.indexOf(' ')) != -1){
            String tmp = str.substring(0, index);
            if(result.length() < tmp.length()){
                result = tmp;
            }
            str = str.substring(index + 1);
        }

        if(result.length() < str.length()){
            result = str;
        }
        return result;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
//        System.out.println(T.solution(input));
        System.out.println(T.solution2_1(input));

    }
}
