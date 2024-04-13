package codingTest.CT.CT22.ct05;
import java.util.*;

public class Solution {
  public int solution(String[] words) {
    int answer = 0;
    TrieNode root = new TrieNode();
    int wordLength = words[0].length();

    for(String word : words){
      TrieNode node = root;
      for(char c : word.toCharArray()){
        int index = c - 'a';
        if(node.children[index] == null){
          node.children[index] = new TrieNode();
        }
        node = node.children[index];
        node.startWith.add(word);
      }
    }

    for(String word : words){
      answer += search(new ArrayList<>(Arrays.asList(word)), wordLength, root);
    }

    return answer;
  }

  private int search(List<String> result, int wordLength, TrieNode root){
    if(result.size() == wordLength){
      return 1;
    }

    int count = 0;
    int index = result.size();
    StringBuilder prefixBuilder = new StringBuilder();
    for(String string : result){
      prefixBuilder.append(string.charAt(index));
    }
    String prefix = prefixBuilder.toString();
    List<String> startWith = root.getStartWith(prefix);

    for(String word : startWith){
      result.add(word);
      count += search(result, wordLength, root);
      result.remove(result.size() - 1);
    }

    return count;
  }
}

class TrieNode {
  TrieNode[] children;
  List<String> startWith;

  TrieNode(){
    children = new TrieNode[26];
    startWith = new ArrayList<>();
  }

  List<String> getStartWith(String prefix){
    TrieNode node = this;
    for(char c : prefix.toCharArray()){
      if(node.children[c - 'a'] == null){
        return new ArrayList<>();
      }
      node = node.children[c - 'a'];
    }
    return node.startWith;
  }
}
