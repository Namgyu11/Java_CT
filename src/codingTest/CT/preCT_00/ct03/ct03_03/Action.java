package codingTest.CT.preCT_00.ct03.ct03_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Action {

    static int M, N; // 격자의 크기 (행과 열)
    static int[][] grid; // 격자의 상태를 저장하는 2차원 배열
    static boolean[][] visited; // 각 격자의 방문 여부를 저장하는 2차원 boolean 배열
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x축 변화량
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y축 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)); // 입력을 효율적으로 처리하기 위해 BufferedReader 사용
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 번째 줄을 공백 기준으로 토큰화

        M = Integer.parseInt(st.nextToken()); // 격자의 행 수
        N = Integer.parseInt(st.nextToken()); // 격자의 열 수

        grid = new int[M][N]; // 격자의 상태를 저장할 2차원 배열 초기화
        visited = new boolean[M][N]; // 각 격자의 방문 여부를 저장할 2차원 배열 초기화

        for (int i = 0; i < M; i++) { // M개의 행을 반복
            String line = br.readLine(); // 각 행을 입력받음
            for (int j = 0; j < N; j++) { // N개의 열을 반복
                grid[i][j] = line.charAt(j) - '0'; // 각 문자를 정수로 변환하여 grid에 저장
            }
        }

        boolean canPercolate = false; // 전류가 안쪽까지 도달할 수 있는지를 나타내는 변수 초기화
        for (int j = 0; j < N; j++) { // 첫 번째 행의 모든 열을 반복
            if (grid[0][j] == 0 && !visited[0][j]) { // 흰색 격자(0)이고 방문하지 않은 경우
                if (bfs(0, j)) { // BFS를 수행하여 마지막 행에 도달할 수 있는지 확인
                    canPercolate = true; // 도달할 수 있으면 canPercolate를 true로 설정
                    break; // 반복 중단
                }
            }
        }

        System.out.println(canPercolate ? "YES" : "NO"); // 결과 출력
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐 초기화
        queue.add(new int[]{x, y}); // 시작 좌표를 큐에 추가
        visited[x][y] = true; // 시작 좌표를 방문으로 표시

        while (!queue.isEmpty()) { // 큐가 비어있지 않은 동안 반복
            int[] current = queue.poll(); // 큐의 맨 앞에 있는 요소를 꺼냄
            int cx = current[0]; // 현재 x 좌표
            int cy = current[1]; // 현재 y 좌표

            if (cx == M - 1) { // 현재 좌표가 마지막 행에 도달하면
                return true; // true 반환
            }

            for (int i = 0; i < 4; i++) { // 네 방향으로 이동
                int nx = cx + dx[i]; // 다음 x 좌표
                int ny = cy + dy[i]; // 다음 y 좌표

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && grid[nx][ny] == 0
                        && !visited[nx][ny]) { // 다음 좌표가 유효한 범위 내에 있고 흰색 격자이며 방문하지 않은 경우
                    visited[nx][ny] = true; // 다음 좌표를 방문으로 표시
                    queue.add(new int[]{nx, ny}); // 다음 좌표를 큐에 추가
                }
            }
        }

        return false; // 마지막 행에 도달하지 못하면 false 반환
    }
}