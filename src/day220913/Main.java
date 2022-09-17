package day220913;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /*
    4. 모든 아나그램 찾기
        설명

    S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

    아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


    입력
    첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

    S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


        출력
    S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


    예시 입력 1

    bacaAacba
        abc
    예시 출력 1

        3
    힌트

    출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
*/

    public static int solution(String str1, String str2) {
        int answer = 0;

        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(char c2 : str2.toCharArray()) {
            hm2.put(c2, hm2.getOrDefault(c2, 0) + 1);
        }

        HashMap<Character, Integer> hm1 = new HashMap<>();
        char[] c1 = str1.toCharArray();
        for(int i = 0; i < str2.length() - 1; i++) {
            hm1.put(c1[i], hm1.getOrDefault(c1[i], 0) + 1);
        }

        int lt = 0;
        for(int rt = str2.length() -1; rt < str1.length(); rt++) { //주의!! str1.length() 만큼 for문 돌아야한다
            hm1.put(str1.charAt(rt), hm1.getOrDefault(str1.charAt(rt), 0) + 1);
            if(hm2.equals(hm1)) {
                answer++;
            }

            hm1.put(str1.charAt(lt), hm1.get(str1.charAt(lt)) -1);
            if(hm1.get(str1.charAt(lt)) == 0) {
                hm1.remove(str1.charAt(lt));
            }

            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        System.out.println(solution(str1, str2));
    }

}
