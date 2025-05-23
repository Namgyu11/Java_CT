package codingTest.programmers.lv3.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            genreSongs
                .computeIfAbsent(g, x -> new ArrayList<>())
                .add(new Song(i, p));
        }
        
        for (List<Song> list : genreSongs.values()) {
            Collections.sort(list, (a, b) -> {
                if (b.play != a.play) {
                    return b.play - a.play;
                }
                return a.id - b.id;
            });
        }
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        Collections.sort(genreOrder, (a, b) -> genreTotal.get(b) - genreTotal.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String g : genreOrder) {
            List<Song> list = genreSongs.get(g);
            result.add(list.get(0).id);
            if (list.size() > 1) {
                result.add(list.get(1).id);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    static class Song {
        int id, play;
        Song(int id, int play) { this.id = id; this.play = play; }
    }
}
