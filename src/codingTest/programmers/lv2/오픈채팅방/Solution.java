package codingTest.programmers.lv2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();
        List<Pair> actions = new ArrayList<>();
        
        for (String rec : record) {
            String[] parts = rec.split(" ");
            String cmd = parts[0];
            String uid = parts[1];
            if (cmd.equals("Enter")) {
                String nick = parts[2];
                nicknames.put(uid, nick);
                actions.add(new Pair(uid, true));
            } else if (cmd.equals("Leave")) {
                actions.add(new Pair(uid, false));
            } else if (cmd.equals("Change")) {
                String nick = parts[2];
                nicknames.put(uid, nick);
            }
        }
        
        String[] answer = new String[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            Pair p = actions.get(i);
            String nick = nicknames.get(p.uid);
            if (p.enter) {
                answer[i] = nick + "님이 들어왔습니다.";
            } else {
                answer[i] = nick + "님이 나갔습니다.";
            }
        }
        return answer;
    }
    
    static class Pair {
        String uid;
        boolean enter;
        Pair(String uid, boolean enter) {
            this.uid = uid;
            this.enter = enter;
        }
    }
}
