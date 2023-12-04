package graphspracticeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartite {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		int n = 3;
		boolean valid = possibleBipartition(n, edges);

	}

	public static boolean possibleBipartition(int n, int[][] dislikes) {
		List<Integer>[] adjList = new List[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int j = 0; j < dislikes.length; j++) {
			int u = dislikes[j][0];
			int v = dislikes[j][1];
			adjList[u - 1].add(v - 1);
			adjList[v - 1].add(u - 1);
		}
		int[] discovered = new int[n];
		int[] parent = new int[n];
		int[] alter = new int[n];

		Arrays.fill(discovered, -1);
		Arrays.fill(parent, -1);
		Arrays.fill(alter, -3);

		for (int i = 0; i < n; i++) {
			if (discovered[i] == -1) {
				alter[i] = 1;
				if (!dfs(i, discovered, parent, alter, adjList)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean dfs(int source, int[] discovered, int[] parent, int[] alter, List<Integer>[] adjList) {
		discovered[source] = 1;
		for (Integer neighbour : adjList[source]) {
			parent[neighbour] = source;
			alter[neighbour] ^= alter[source];
			if (discovered[neighbour] == -1) {
				if (!dfs(neighbour, discovered, parent, alter, adjList)) {
					return false;
				}
			} else {
				if (neighbour != parent[source] && (alter[neighbour] == alter[source])) {
					return false;
				}
			}
		}
		return true;
	}

}
