package graphspracticeproblems;

import java.util.Arrays;

public class IsGraphBipartite {

	public static void main(String[] args) {
		int[][] edges = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean valid = isBipartite(edges);

	}

	private static boolean isBipartite(int[][] graph) {
		boolean validate = true;
		int[] discovered = new int[graph.length];
		Arrays.fill(discovered, -1);
		int[] parent = new int[graph.length];
		Arrays.fill(parent, -1);
		int[] alter = new int[graph.length];
		Arrays.fill(alter, -1);

		for (int i = 0; i < graph.length; i++) {
			if (discovered[i] == -1) {
				alter[i] = 1;
				validate = dfs(i, graph, discovered, alter, parent);
			}
			if (!validate) {
				return false;
			}
		}
		return validate;
	}

	private static boolean dfs(int source, int[][] graph, int[] discovered, int[] alter, int[] parent) {
		discovered[source] = 1;
		for (int i = 0; i < graph[source].length; i++) {
			int neighbour = graph[source][i];
			if (discovered[neighbour] == -1) {
				parent[neighbour] = source;
				alter[neighbour] ^= alter[source];
				if (!dfs(neighbour, graph, discovered, alter, parent)) {
					return false;
				}
			} else {
				if (neighbour != parent[source] &&  (alter[neighbour] == alter[source])) {
						return false;
					
				}
			}
		}
		return true;
	}
}
