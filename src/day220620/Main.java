package day220620;

import java.util.Scanner;

public class Main {

    public static String solution(String input){
        input += " ";
        char[] s = input.toCharArray();
        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length()-1; i++){
            if(s[i] == s[i+1]){
                cnt++;
            }else{
                sb.append(s[i]);
                if(cnt > 1){
                    sb.append(cnt);
                }
                cnt = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        System.out.println(solution(input));
    }

}
