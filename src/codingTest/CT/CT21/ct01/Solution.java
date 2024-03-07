package codingTest.CT.CT21.ct01;
import java.util.*;

public class Solution {
  ArrayList<String> answer = new ArrayList<>();
  String[] words;
  boolean[] visited;

  public String[] solution(String[] phrases) {
    words = phrases;
    visited = new boolean[phrases.length];
    for(int i = 0; i < phrases.length; i++){
      visited[i] = true;
      dfs(phrases[i], phrases[i].split(" ")[phrases[i].split(" ").length-1], 1);
      visited[i] = false;
    }
    Collections.sort(answer);
    return answer.toArray(new String[0]);
  }

  void dfs(String current, String lastWord, int count){
    if(count == words.length){
      answer.add(current);
      return;
    }
    for(int i = 0; i < words.length; i++){
      if(visited[i]) continue;
      String[] split = words[i].split(" ");
      if(split[0].equals(lastWord)){
        visited[i] = true;
        dfs(current + " " + String.join(" ", Arrays.copyOfRange(split, 1, split.length)), split[split.length-1], count+1);
        visited[i] = false;
      }
    }
  }

}
