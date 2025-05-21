package codingTest.programmers.lv2.파일명정렬;

import java.util.*;

class Solution {
    static class FileEntry {
        String original;
        String head;
        int number;
        int index;
        FileEntry(String original, String head, int number, int index) {
            this.original = original;
            this.head = head;
            this.number = number;
            this.index = index;
        }
    }
    
    public String[] solution(String[] files) {
        List<FileEntry> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String f = files[i];
            int len = f.length();
            int j = 0;
            while (j < len && !Character.isDigit(f.charAt(j))) {
                j++;
            }
            String head = f.substring(0, j).toLowerCase();
            int k = j;
            while (k < len && Character.isDigit(f.charAt(k)) && k - j < 5) {
                k++;
            }
            int number = Integer.parseInt(f.substring(j, k));
            list.add(new FileEntry(f, head, number, i));
        }
        Collections.sort(list, (a, b) -> {
            int cmp = a.head.compareTo(b.head);
            if (cmp != 0) {
                return cmp;
            }
            if (a.number != b.number) {
                return Integer.compare(a.number, b.number);
            }
            return Integer.compare(a.index, b.index);
        });
        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original;
        }
        return answer;
    }
}
