package codingTest.programmers.lv2.충돌위험찾기;

import java.util.*;

class Solution {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int numRobots = routes.length;
        List<List<Point>> timelines = new ArrayList<>();
        int maxTime = 0;
        
        for (int i = 0; i < numRobots; i++) {
            int[] route = routes[i];
            List<Point> timeline = new ArrayList<>();
            
            int startPointNum = route[0];
            int[] startCoords = points[startPointNum - 1];
            int currR = startCoords[0];
            int currC = startCoords[1];
            timeline.add(new Point(currR, currC));
            
            for (int j = 1; j < route.length; j++) {
                int destPointNum = route[j];
                int[] destCoords = points[destPointNum - 1];
                int destR = destCoords[0];
                int destC = destCoords[1];
                
                while (currR != destR) {
                    if (currR < destR) {
                        currR++;
                    } else {
                        currR--;
                    }
                    timeline.add(new Point(currR, currC));
                }
                while (currC != destC) {
                    if (currC < destC) {
                        currC++;
                    } else {
                        currC--;
                    }
                    timeline.add(new Point(currR, currC));
                }
            }
            timelines.add(timeline);
            maxTime = Math.max(maxTime, timeline.size());
        }
        
        int totalCollisions = 0;
        for (int t = 0; t < maxTime; t++) {
            HashMap<String, Integer> positionCount = new HashMap<>();
            for (int i = 0; i < numRobots; i++) {
                List<Point> timeline = timelines.get(i);
                if (t >= timeline.size()) {
                    continue;
                }
                Point p = timeline.get(t);
                String key = p.r + "," + p.c;
                positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
            }
            for (int count : positionCount.values()) {
                if (count >= 2) {
                    totalCollisions++;
                }
            }
        }
        
        return totalCollisions;
    }
}
