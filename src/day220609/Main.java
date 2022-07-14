package day220609;

public class Main {

    public static String solution(String input){
        String result = "YES";
        input = input.toUpperCase();

        int len = input.length();
        for(int i = 0; i < len/2; i++){
            if(input.charAt(i) != input.charAt(len-i-1)){
                return "NO";
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
