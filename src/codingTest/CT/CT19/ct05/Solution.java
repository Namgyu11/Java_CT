package codingTest.CT.CT19.ct05;

import java.util.Arrays;

public class Solution {

  public static int[] solution(String[] strings) {
    int[] answer = new int[4];
    String[] str;
    for (String string : strings) {
      str = string.split(" ");
      if (str[0].contains(".mp3") || str[0].contains(".flac") || str[0].contains(".aac")) {
        answer[0] += Integer.parseInt(str[1].replace("b", ""));
      } else if (str[0].contains(".jpg") || str[0].contains(".bmp") || str[0].contains(".gif")) {
        answer[1] += Integer.parseInt(str[1].replace("b", ""));
      } else if (str[0].contains(".mp4") || str[0].contains(".avi") || str[0].contains(".mkv")) {
        answer[2] += Integer.parseInt(str[1].replace("b", ""));
      } else {
        answer[3] += Integer.parseInt(str[1].replace("b", ""));
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    solution(new String[]{"mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b"
        , "video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"});
  }
}
