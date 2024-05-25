package studyCT.CT06;

import java.util.*;
import java.text.*;

class Solution {
      public int[] solution(String today, String[] terms, String[] privacies) {
            // 오늘 날짜를 Date로 변환
            Date todayDate = parseDate(today);

            // 약관 종류와 유효기간을 매핑
            Map<String, Integer> termMap = new HashMap<>();
            for (String term : terms) {
                  String[] splitTerm = term.split(" ");
                  String termType = splitTerm[0];
                  int duration = Integer.parseInt(splitTerm[1]);
                  termMap.put(termType, duration);
            }

            // 파기해야 할 개인정보 번호를 저장할 리스트
            List<Integer> result = new ArrayList<>();

            // 개인정보 수집 일자를 순회하며 유효기간을 계산
            for (int i = 0; i < privacies.length; i++) {
                  String[] splitPrivacy = privacies[i].split(" ");
                  String collectedDateStr = splitPrivacy[0];
                  String termType = splitPrivacy[1];

                  Date collectedDate = parseDate(collectedDateStr);
                  int duration = termMap.get(termType);

                  // 개인정보 보관 유효기간 계산
                  Date expiryDate = addMonths(collectedDate, duration);

                  // 만료일이 오늘 날짜보다 이전이라면 파기 대상
                  if (!expiryDate.after(todayDate)) {
                        result.add(i + 1);
                  }
            }

            // 결과를 오름차순 정렬된 배열로 변환하여 반환
            Collections.sort(result);
            return result.stream().mapToInt(i -> i).toArray();
      }

      // 날짜를 "YYYY.MM.DD" 형식에서 Date 객체로 변환하는 함수
      private Date parseDate(String dateStr) {
            try {
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                  return sdf.parse(dateStr);
            } catch (ParseException e) {
                  throw new RuntimeException("Invalid date format: " + dateStr);
            }
      }

      // 날짜에 월을 더하는 함수
      private Date addMonths(Date date, int months) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, months);
            return cal.getTime();
      }
}
