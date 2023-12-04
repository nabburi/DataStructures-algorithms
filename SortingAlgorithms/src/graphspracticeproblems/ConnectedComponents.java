package graphspracticeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponents {

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0,1}, {1,2}, {2,3}, {4,5}};
		int i = -3;
		i ^= i;
		int compmonents = countComponents(n, edges);
	}

	private static int countComponents(int n, int[][] edges) {
		int components = 0;
		List<Integer>[] adjList = new List[n];

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edges.length; i++) {
			adjList[edges[i][0]].add(edges[i][1]);
			adjList[edges[i][1]].add(edges[i][0]);
		}

		int[] visited = new int[n];
		Arrays.fill(visited, -1);
		for (int i = 0; i < n; i++) {
			if (visited[i] == -1) {
				components++;
				dfs(i, visited, adjList);
			}
		}
		return components;
	}

	private static void dfs(int source, int[] visited, List<Integer>[] adjList) {
		visited[source] = 1;
		List<Integer> list = adjList[source];
		for (Integer neighbour : list) {
			//for (int neighbour : list) {
				if (visited[neighbour] == -1) {
					dfs(neighbour, visited, adjList);
				//}
			}
		}
	}
}
