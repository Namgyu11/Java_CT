package codingTest.CT.CT_FINAL.ct08;
//24-03-23 다시 풀기
public class Solution {
  public int solution(String src, String dst) {
    int srcLen = src.length();
    int dstLen = dst.length();
    int srcIndex = 0, dstIndex = 0;
    int answer = 0;

    while (dstIndex < dstLen) {
      boolean found = false;
      for (; srcIndex < srcLen; srcIndex++) {
        if (src.charAt(srcIndex) == dst.charAt(dstIndex)) {
          found = true;
          dstIndex++;
          if (dstIndex == dstLen) {
            answer++;
            break;
          }
        }
      }

      if (!found) {
        return -1;
      }

      if (srcIndex == srcLen && dstIndex < dstLen) {
        answer++;
        srcIndex = 0;
      }
    }

    return answer;
  }

}
