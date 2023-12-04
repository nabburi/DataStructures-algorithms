package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphImplementation {


	LinkedList<Integer>[] adjList;
	int V;

	GraphImplementation(int size) {
		this.V = size;
		this.adjList = new LinkedList[V];
	}
	
	private void addEdge(int start, int end, boolean bidir) {
		this.adjList[start].add(end);
		if(bidir == true) {
			this.adjList[end].add(start);
		}
	}
	
	private boolean hasEulerianCycle() {
		int odd = 0;
		for (int i = 0; i < this.adjList.length;i++) {
			if((this.adjList[i].size()% 2) == 1) {
				odd++;
			}
		}
		if(odd == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean hasEulerianPath() {
		int odd =0;
		for(int i =0; i< this.adjList.length;i++) {
			if((this.adjList[i].size() % 2) == 1) {
				odd++;
			}
		}
		if(odd ==0 || odd == 2) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
