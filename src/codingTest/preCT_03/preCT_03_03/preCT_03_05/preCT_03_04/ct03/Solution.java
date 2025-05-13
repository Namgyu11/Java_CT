package codingTest.preCT_03.preCT_03_03.preCT_03_05.preCT_03_04.ct03;



//23-10-08(풀이) -- 다시 풀기 !!
public class Solution {
    public static int[][] solution(int[][] city) {
        int h = city.length;
        int w = city[0].length;

        int[][] dist = new int[h][w];

        // 초기값 설정
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (city[i][j] == 1)
                    dist[i][j] = h*w;
                else
                    dist[i][j] = 0;
            }
        }

        // 왼쪽 위에서 오른쪽 아래로 스캔
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if(i>0)
                    dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                if(j>0)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
            }
        }

        // 오른쪽 아래에서 왼쪽 위로 스캔
        for(int i=h-1;i>=0;i--){
            for(int j=w-1;j>=0;j--){
                if(i<h-1)
                    dist[i][j]=Math.min(dist[i+1][j]+1,dist[i][j]);
                if(j<w-1)
                    dist[i][j]=Math.min(dist[i][j+1]+1,dist[i][j]);
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] city =  {{1,0,1}, {1,1,1}, {1,1,1}};
    }
}
