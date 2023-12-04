package graphspracticeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {

	public static void main(String[] args) {
		int numc = 4;
		int[][] prerep = {{1,0},{2,0},{3,1},{3,2}};
		int[] ord = findOrder(numc, prerep);
	}

	private static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] topoSort = new int[numCourses];
		List<Integer> ts  =new ArrayList<>();
		boolean canFinish = true;
		int timestp = 0;
		List<Integer>[] adjList = new List[numCourses];
		for (int i = 0; i < numCourses; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int j = 0; j < prerequisites.length; j++) {
			int u = prerequisites[j][0];
			int v = prerequisites[j][1];
			adjList[v].add(u);
		}
		int[] discovered = new int[numCourses];
		int[] arrivalTime = new int[numCourses];
		int[] depatureTime = new int[numCourses];

		Arrays.fill(discovered, -1);
		Arrays.fill(arrivalTime, -1);
		Arrays.fill(depatureTime, -1);

		for (int k = 0; k < numCourses; k++) {
			if (discovered[k] == -1) {
				canFinish = dfs(k, discovered, arrivalTime, depatureTime, adjList, timestp, topoSort,ts);
			}
			if (!canFinish) {
				topoSort = null;
				return topoSort;
			}
		}
		for (int l = 0; l < ts.size(); l++) {
			topoSort[l] = ts.get(ts.size()-l-1);
		}
		LinkedList<String> tmp = new LinkedList<String>();

		return topoSort;
	}

	private static boolean dfs(int source, int[] discovered, int[] arrivalTime, int[] depatureTime, List<Integer>[] adjList,
			int timestp, int[] topoSort, List<Integer> ts) {
		arrivalTime[source] = timestp++;
		//topoSort[timestp] = source;
		discovered[source] = 1;
		for (Integer neighbour : adjList[source]) {
			if (discovered[neighbour] == -1) {
				if (!dfs(neighbour, discovered, arrivalTime, depatureTime, adjList, timestp, topoSort, ts)) {
					return false;
				}
			} else {
				if (depatureTime[neighbour] == -1) {
					return false;
				}
			}
		}
		depatureTime[source] = timestp++;
		ts.add(source);
		topoSort[topoSort.length-source-1] = source;
		return true;
	}
}
