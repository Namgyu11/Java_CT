package codingTest.preCT_03.preCT_03_01.ct01.ct04.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.preCT_03_03.preCT_03_04.ct01.ct03.수레움직이기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    class State {
        int rR, cR, rB, cB, redMask, blueMask, turns;
        State(int rR, int cR, int rB, int cB, int redMask, int blueMask, int turns) {
            this.rR = rR; this.cR = cR; this.rB = rB; this.cB = cB;
            this.redMask = redMask; this.blueMask = blueMask; this.turns = turns;
        }
    }
    int R, C;
    int redDestR, redDestC, blueDestR, blueDestC;
    int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

    public int solution(int[][] maze) {
        R = maze.length; C = maze[0].length;
        int redStartR = -1, redStartC = -1, blueStartR = -1, blueStartC = -1;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if(maze[i][j] == 1){ redStartR = i; redStartC = j; }
                else if(maze[i][j] == 2){ blueStartR = i; blueStartC = j; }
                else if(maze[i][j] == 3){ redDestR = i; redDestC = j; }
                else if(maze[i][j] == 4){ blueDestR = i; blueDestC = j; }
            }
        }

        int startRedMask = 1 << (redStartR * C + redStartC);
        int startBlueMask = 1 << (blueStartR * C + blueStartC);
        State start = new State(redStartR, redStartC, blueStartR, blueStartC, startRedMask, startBlueMask, 0);
        Queue<State> queue = new LinkedList<>();
        queue.offer(start);
        HashSet<String> visited = new HashSet<>();
        visited.add(encode(start));

        while(!queue.isEmpty()){
            State cur = queue.poll();
            if (cur.rR == redDestR && cur.cR == redDestC && cur.rB == blueDestR
                    && cur.cB == blueDestC) {
                return cur.turns;
            }
            List<int[]> redMoves = new ArrayList<>();
            if(cur.rR == redDestR && cur.cR == redDestC){
                redMoves.add(new int[]{cur.rR, cur.cR});
            } else {
                for (int d = 0; d < 4; d++){
                    int nr = cur.rR + dr[d], nc = cur.cR + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }
                    if (maze[nr][nc] == 5) {
                        continue;
                    }
                    int posBit = 1 << (nr * C + nc);
                    if ((cur.redMask & posBit) != 0) {
                        continue;
                    }
                    redMoves.add(new int[]{nr, nc});
                }
            }

            List<int[]> blueMoves = new ArrayList<>();
            if(cur.rB == blueDestR && cur.cB == blueDestC){
                blueMoves.add(new int[]{cur.rB, cur.cB});
            } else {
                for (int d = 0; d < 4; d++){
                    int nr = cur.rB + dr[d], nc = cur.cB + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        continue;
                    }
                    if (maze[nr][nc] == 5) {
                        continue;
                    }
                    int posBit = 1 << (nr * C + nc);
                    if ((cur.blueMask & posBit) != 0) {
                        continue;
                    }
                    blueMoves.add(new int[]{nr, nc});
                }
            }

            for (int[] rmove : redMoves){
                for (int[] bmove : blueMoves){
                    if (rmove[0] == bmove[0] && rmove[1] == bmove[1]) {
                        continue;
                    }
                    if (!(cur.rR == redDestR && cur.cR == redDestC) &&
                            !(cur.rB == blueDestR && cur.cB == blueDestC) &&
                            rmove[0] == cur.rB && rmove[1] == cur.cB &&
                            bmove[0] == cur.rR && bmove[1] == cur.cR) {
                        continue;
                    }
                    int newRedMask = cur.redMask;
                    int newBlueMask = cur.blueMask;
                    if (!(cur.rR == redDestR && cur.cR == redDestC)) {
                        newRedMask |= (1 << (rmove[0] * C + rmove[1]));
                    }
                    if (!(cur.rB == blueDestR && cur.cB == blueDestC)) {
                        newBlueMask |= (1 << (bmove[0] * C + bmove[1]));
                    }
                    State ns = new State(rmove[0], rmove[1], bmove[0], bmove[1], newRedMask, newBlueMask, cur.turns + 1);
                    String code = encode(ns);
                    if (visited.contains(code)) {
                        continue;
                    }
                    visited.add(code);
                    queue.offer(ns);
                }
            }
        }
        return 0;
    }
    String encode(State s) {
        return s.rR+","+s.cR+","+s.rB+","+s.cB+","+s.redMask+","+s.blueMask;
    }
}
