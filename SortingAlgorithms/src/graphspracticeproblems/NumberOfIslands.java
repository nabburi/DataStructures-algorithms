package graphspracticeproblems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		int islands = numIslands(grid);

	}

	private static int numIslands(char[][] grid) {
		int islands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != '0') {
					dfs(i, j, grid);
					islands += 1;
				}
			}
		}
		return islands;
	}

	private static void dfs(int i, int j, char[][] grid) {
		grid[i][j] = '0';
		List<Integer>[] neighbours = getNeighbours(i, j, grid);
		for (List<Integer> list : neighbours) {
			if (!list.isEmpty()) {
				int x = list.get(0);
				int y = list.get(1);
				if (grid[x][y] != '0') {
					dfs(x, y, grid);
				}
			}
		}
	}

	private static List<Integer>[] getNeighbours(int x, int y, char[][] grid) {
		List<Integer>[] result = new List[4];
		for (int i = 0; i < result.length; i++) {
			result[i] = new ArrayList<Integer>();
		}

		if (x + 1 < grid.length) {
			result[0].add(x + 1);
			result[0].add(y);
		}
		if (y + 1 < grid[0].length) {
			result[1].add(x);
			result[1].add(y + 1);
		}
		if (x - 1 >= 0) {
			result[2].add(x - 1);
			result[2].add(y);
		}
		if (y - 1 >= 0) {
			result[3].add(x);
			result[3].add(y - 1);
		}

		return result;
	}
}
