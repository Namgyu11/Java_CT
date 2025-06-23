package codingTest.programmers.lv3.매칭_점수;

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String word, String[] pages) {
        int n = pages.length;
        word = word.toLowerCase();
        
        // Patterns
        Pattern metaPattern = Pattern.compile(
            "<meta[^>]*property=\"og:url\"[^>]*content=\"([^\"]+)\"[^>]*>",
            Pattern.CASE_INSENSITIVE);
        Pattern linkPattern = Pattern.compile(
            "<a href=\"(https://[^\"]+)\"",
            Pattern.CASE_INSENSITIVE);
        
        String[] urls = new String[n];
        double[] basic = new double[n];
        int[] outCount = new int[n];
        List<String>[] outLinks = new List[n];
        
        for (int i = 0; i < n; i++) {
            String html = pages[i];
            Matcher mMeta = metaPattern.matcher(html);
            if (mMeta.find()) {
                urls[i] = mMeta.group(1);
            }
            outLinks[i] = new ArrayList<>();
            Matcher mLink = linkPattern.matcher(html);
            while (mLink.find()) {
                outLinks[i].add(mLink.group(1));
            }
            outCount[i] = outLinks[i].size();
            String body = html.toLowerCase()
                              .replaceAll("<[^>]+>", " ")
                              .replaceAll("[^a-z]", " ");
            String[] tokens = body.split("\\s+");
            int cnt = 0;
            for (String t : tokens) {
                if (t.equals(word)) {
                    cnt++;
                }
            }
            basic[i] = cnt;
        }
        
        Map<String,Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(urls[i], i);
        }
        
        double[] linkScore = new double[n];
        for (int i = 0; i < n; i++) {
            if (outCount[i] == 0) {
                continue;
            }
            double share = basic[i] / outCount[i];
            for (String toUrl : outLinks[i]) {
                Integer j = idxMap.get(toUrl);
                if (j != null) {
                    linkScore[j] += share;
                }
            }
        }
        
        double maxScore = -1;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            double match = basic[i] + linkScore[i];
            if (match > maxScore) {
                maxScore = match;
                answer = i;
            }
        }
        return answer;
    }
}
