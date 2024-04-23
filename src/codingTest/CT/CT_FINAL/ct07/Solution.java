package codingTest.CT.CT_FINAL.ct07;

//24-03-23 다시 풀기 -- 백 트래킹
public class Solution {
  public boolean solution(int[] cards) {
    return canWin(cards, true);
  }

  private boolean canWin(int[] cards, boolean isMyTurn) {
    for (int i = 0; i < cards.length - 1; i++) {
      if (cards[i] == 1 && cards[i + 1] == 1) {
        cards[i] = cards[i + 1] = 0;
        boolean canOpponentWin = canWin(cards, !isMyTurn);
        cards[i] = cards[i + 1] = 1;
        if (!canOpponentWin) {
          return true;
        }
      }
    }
    return false;
  }
}
