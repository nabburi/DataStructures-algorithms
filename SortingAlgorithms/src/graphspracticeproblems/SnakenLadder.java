package graphspracticeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakenLadder {

	public static void main(String[] args) {
		int[][] board = {{-1,-1,-1,-1,-1,-1},
				         {-1,-1,-1,-1,-1,-1},
				         {-1,-1,-1,-1,-1,-1},
				         {-1,35,-1,-1,13,-1},
				         {-1,-1,-1,-1,-1,-1},
				         {-1,15,-1,-1,-1,-1}};
		int macnum = snakesAndLadders(board);

	}

	private static int snakesAndLadders(int[][] board) {
		int n = board.length * board.length;
		boolean flag = true;
		Map<Integer, Integer> boardmap = new HashMap<>();
		int key = 0;
		for (int x = board.length - 1; x >= 0; x--) {
			if(flag) {
			for (int y = 0; y < board.length; y++) {
				key++;
				if(board[x][y] == -1) {
					boardmap.put(key, key);
				}else {
				boardmap.put(key, board[x][y]);
				}
				flag = false;
			}
		}else {
			for (int y = board.length-1; y >= 0; y--) {
				key++;
				if(board[x][y] == -1) {
					boardmap.put(key, key);
				}else {
				boardmap.put(key, board[x][y]);
				}
				flag = true;
			}
		}
		}
		List<Integer>[] adjList = new List[n];
		for (int k = 0; k < adjList.length; k++) {
			adjList[k] = new ArrayList<Integer>();
		}
		int[] discovered = new int[n];
		Arrays.fill(discovered, -1);
		int[] distance = new int[n];
		Arrays.fill(distance, -1);
		for (int i = 0; i < n; i++) {
			for (int dice = 1; dice <= 6; dice++) {
				if (i + dice+1 <= board.length * board.length) {
					adjList[i].add(boardmap.get(i + dice+1));
				}
			}
		}
		bfs(discovered, 1, board, distance, adjList);
		return distance[n - 1];
	}

	private static void bfs(int[] discovered, int source, int[][] board, int[] distance, List<Integer>[] adjList) {
		discovered[source-1] = 1;
		distance[source-1] = 0;
		Queue<Integer> dq = new LinkedList<Integer>();
		dq.add(source);
		while (!dq.isEmpty()) {
			int node = dq.remove();
			for(int neighbour=1; neighbour<=adjList[node-1].size();neighbour++) {
				int nei = adjList[node-1].get(neighbour-1);
				
				if (discovered[nei-1] == -1) {
					discovered[nei-1] = 1;
					distance[nei-1] = distance[node-1] + 1;
					dq.add(nei);
				}
			}
		}
	}
}
