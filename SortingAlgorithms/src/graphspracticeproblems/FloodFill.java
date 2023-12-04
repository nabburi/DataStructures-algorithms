package graphspracticeproblems;

import java.util.ArrayList;
import java.util.List;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int sr = 1;
		int sc = 1;
		int color = 2;
		image = floodFill(image, sr, sc, color);

	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int color) {

		int fillcolor = image[sr][sc];
		dfs(sr, sc, image, color, fillcolor);
		return image;
	}

	private static void dfs(int x, int y, int[][] image, int color, int fillcolor) {
		if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != fillcolor) {
			return;
		}
		image[x][y] = color;
		dfs(x + 1, y, image, color, fillcolor);
		dfs(x - 1, y, image, color, fillcolor);
		dfs(x, y + 1, image, color, fillcolor);
		dfs(x, y - 1, image, color, fillcolor);
	}

	private static List<List<Integer>> getNeighbours(int x, int y, int[][] image) {
		List<List<Integer>> neighbours = new ArrayList<>();

		if (x + 1 < image.length) {
			neighbours.add(List.of(x + 1, y));
		}
		if (y + 1 < image[0].length) {
			neighbours.add(List.of(x, y + 1));
		}
		if (x - 1 >= 0) {
			neighbours.add(List.of(x - 1, y));
		}
		if (y - 1 >= 0) {
			neighbours.add(List.of(x, y - 1));
		}
		return neighbours;
	}
}
