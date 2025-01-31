package codingTest.bj.bj15684;

import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int h;
	static int minCnt = -1;

	static int[][] map;
	static boolean finished;
	static final int EMPTY = 0, RIGHT = 1, LEFT = 2;

	static void backtrack(int y, int x, int addedCnt, int finishCnt) {
		if (finished) {
			return;
		}

		if (addedCnt == finishCnt) {
			if (checkAllVLines()) {
				finished = true;
			}
			return;
		}

		for (int i = y; i <= h; i++) {
			for (int j = x; j < n; j++) {
				if (map[i][j] == EMPTY && map[i][j+1] == EMPTY) {
					int nx = (x + 1 < n) ? x + 1 : 1;
					int ny = (nx == 1) ? y + 1 : y;

					map[i][j] = RIGHT;
					map[i][j+1] = LEFT;
					backtrack(ny, nx, addedCnt + 1, finishCnt);

					map[i][j] = EMPTY;
					map[i][j+1] = EMPTY;
				}
			}
		}
	}

	static boolean checkAllVLines() {
		for (int vLineIdx = 1; vLineIdx <= n; vLineIdx++) {
			if (!checkVLines(vLineIdx)) {
				return false;
			}
		}
		return true;
	}

	static boolean checkVLines(int vLineIdx) {
		int vIdx = vLineIdx;
		int hIdx = 1;

		while (hIdx <= h) {
			if (map[hIdx][vIdx] == RIGHT) {
				vIdx++;
			} else if (map[hIdx][vIdx] == LEFT) {
				vIdx--;
			}
			hIdx++;
		}
		return vIdx == vLineIdx;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = RIGHT;
			map[a][b+1] = LEFT;
		}

		for (int finishCnt = 0; finishCnt <= 3; finishCnt++) {
			backtrack(1, 1, 0, finishCnt);

			if (finished) {
				minCnt = finishCnt;
				break;
			}
		}

		System.out.println(minCnt);
	}
}