package day220913;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> reporterAndTarget = new HashMap<>(); //key: 신고자, value: 피 신고자(신고 받은 사람)
        HashMap<String, Integer> reportedCnt = new HashMap<>(); //key: 피 신고자, value: 몇 번 신고 받았는지

        for(String str: report) {
            String[] s = str.split(" ");
            String reporter = s[0];
            String beReported = s[1];

            if(!reporterAndTarget.containsKey(reporter)) {
                HashSet<String> hs = new HashSet<>();
                hs.add(beReported);
                reporterAndTarget.put(reporter, hs);

                reportedCnt.put(beReported, reportedCnt.getOrDefault(beReported, 0) + 1);
            } else {
                HashSet<String> beReportedDetail = reporterAndTarget.get(reporter);

                if(!beReportedDetail.contains(beReported)) {
                    reportedCnt.put(beReported, reportedCnt.getOrDefault(beReported, 0) + 1);
                }

                beReportedDetail.add(beReported);
                reporterAndTarget.put(reporter, beReportedDetail);
            }
        }

        int answerCnt = 0;
        for(String id: id_list) {
            HashSet<String> beReportedListById = reporterAndTarget.get(id);
            int getReportCnt = 0; // id가 이메일 안내 받을 카운트
            if(beReportedListById != null && beReportedListById.size() > 0) {
                for(String r : beReportedListById) {
                    if(reportedCnt.get(r) != null && reportedCnt.get(r) >= k) {
                        getReportCnt++;
                    }
                }
            }
            answer[answerCnt] = getReportCnt;
            answerCnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi",
            "frodo",
            "apeach",
            "neo"};

        String[] report = {"muzi frodo",
            "apeach frodo",
            "frodo neo",
            "muzi neo",
            "apeach muzi"};

        int k = 2;
        solution(id_list, report, k);
    }
/*
id_list:
["muzi",
"frodo",
"apeach",
"neo"]

report: 신고자 피신고자
    ["muzi frodo",
    "apeach frodo",
    "frodo neo",
    "muzi neo",
    "apeach muzi"]

result
[2,
1,
1,
0]

피 신고자는 k번 이상 신고 받았을 때 정지 당하고, 신고자한테 메일이 감
한 신고자는 여러번 신고 할 수 있는데, 피신고자 카운트는 최초 1번만 카운트 됨
*/
}
