package codingTest.programmers.lv2.교점에별만들기;

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<Point> points = new ArrayList<>();
        
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0], B = line[i][1], C = line[i][2];
                long D = line[j][0], E = line[j][1], F = line[j][2];
                
                long det = A * E - B * D;
                if (det == 0) {
                    continue;
                }
                
                long xNumer = B * F - C * E;
                long yNumer = C * D - A * F;

                if (xNumer % det != 0 || yNumer % det != 0) {
                    continue;
                }
                
                long x = xNumer / det;
                long y = yNumer / det;
                
                points.add(new Point(x, y));
            }
        }
        
        if(points.isEmpty()){
            return new String[0];
        }
        
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        for (Point p : points) {
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        }
        
        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);
        
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }
        
        for (Point p : points) {
            int col = (int)(p.x - minX);
            int row = (int)(maxY - p.y);
            grid[row][col] = '*';
        }
        
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        return answer;
    }
}

class Point {
    long x, y;
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
