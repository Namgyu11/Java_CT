package studyCT.CT04.ct02;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, result = 0; // 연구소의 크기와 안전 영역의 최대 크기를 저장하는 변수
    static int[][] map, copyMap; // 연구소의 지도와 복사본을 저장하는 배열
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 상하좌우 이동을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 연구소의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 연구소의 가로 크기

        map = new int[N][M]; // 연구소의 지도
        copyMap = new int[N][M]; // 지도의 복사본

        // 지도의 정보를 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0); // 벽을 세우는 모든 경우의 수를 탐색
        System.out.println(result); // 안전 영역의 최대 크기를 출력
    }

    // 벽을 세우는 모든 경우의 수를 탐색하는 DFS 함수
    static void dfs(int x, int y, int depth) {
        if (depth == 3) { // 벽을 3개 세운 경우
            copyMap(); // 지도를 복사
            spreadVirus(); // 바이러스를 퍼뜨림
            result = Math.max(result, getSafeArea()); // 안전 영역의 최대 크기를 갱신
            return;
        }

        // 지도의 모든 위치를 순회
        for (int i = x; i < N; i++, y = 0) {
            for (int j = y; j < M; j++) {
                if (map[i][j] == 0) { // 빈 칸인 경우
                    map[i][j] = 1; // 벽을 세움
                    dfs(i, j, depth + 1); // 다음 벽을 세우기 위해 DFS 수행
                    map[i][j] = 0; // 벽을 제거 (백트래킹)
                }
            }
        }
    }

    // 바이러스를 퍼뜨리는 함수
    static void spreadVirus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 2) { // 바이러스가 있는 위치에서
                    for (int k = 0; k < 4; k++) { // 상하좌우로
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 지도 범위 내이고 빈 칸인 경우
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if (copyMap[nx][ny] == 0) {
                                copyMap[nx][ny] = 2; // 바이러스를 퍼뜨림
                                spreadVirus(); // 재귀적으로 바이러스를 퍼뜨림
                            }
                        }
                    }
                }
            }
        }
    }

    // 지도를 복사하는 함수
    static void copyMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    // 안전 영역의 크기를 반환하는 함수
    static int getSafeArea() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) safe++; // 빈 칸의 개수를 세어 안전 영역의 크기를 계산
            }
        }
        return safe;
    }
}