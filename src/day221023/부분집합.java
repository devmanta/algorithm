package day221023;

public class 부분집합 {

    /**
     * 부분집합 구하기, 단 공집합은 출력하지 않는다.
     *
     * 예)
     * 입력: 3
     * 출력:
     * 1 2 3
     * 1 2
     * 1 3
     * 1
     * 2 3
     * 2
     * 3
     */

    static int n;
    static int[] ch;

    public static void DFS(int L) {
        if(L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <=n ; i++) {
                if(ch[i] == 1) {
                    sb.append(i).append(" ");
                }
            }

            if(sb.length() > 0) {
                System.out.println(sb.toString());
            }

        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }



}
