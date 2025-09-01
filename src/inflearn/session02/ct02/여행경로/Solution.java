package inflearn.session02.ct02.여행경로;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    private Map<String, PriorityQueue<String>> flights = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        for (String[] t : tickets) {
            flights
                .computeIfAbsent(t[0], x -> new PriorityQueue<>())
                .offer(t[1]);
        }
        dfs("ICN");
        return itinerary.toArray(new String[0]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> dests = flights.get(airport);
        while (dests != null && !dests.isEmpty()) {
            String next = dests.poll();
            dfs(next);
        }
        itinerary.addFirst(airport);
    }
}
