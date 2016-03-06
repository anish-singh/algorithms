package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Sample graph code.
public class Graph {

	ArrayList<Vertex> nodes = new ArrayList<Vertex>();
	boolean[] visited;
	Vertex[] parents;
	int[] pathLength;

	class Edge {
		Vertex next;
		int weight;

		Edge(Vertex v) {
			next = v;
		}
		Edge(Vertex v, int w) {
			this(v);
			weight = w;
		}

	}

	class Vertex
	{
		List<Edge> edges;
		int num;

		Vertex(int id) {
			num = id;
		}

		/**
		 * addEdge
		 * 
		 * @param nodeNum
		 *            create edge from this node to nodeNum
		 */

		void addEdge(Vertex n) {
			Edge e = new Edge(n);
			if (edges == null)
				edges = new ArrayList<Edge>();
			
			edges.add(e);

		}
	}

	private void createGraph() {
		nodes.add(new Vertex(0));
		nodes.add(new Vertex(1));
		nodes.add(new Vertex(2));
		nodes.add(new Vertex(3));
		nodes.add(new Vertex(4));
		nodes.add(new Vertex(5));

		nodes.get(0).addEdge(nodes.get(1));
		nodes.get(0).addEdge(nodes.get(2));
		nodes.get(2).addEdge(nodes.get(0));
		nodes.get(1).addEdge(nodes.get(0));
		nodes.get(1).addEdge(nodes.get(3));
		nodes.get(3).addEdge(nodes.get(1));
		nodes.get(2).addEdge(nodes.get(5));
		nodes.get(5).addEdge(nodes.get(2));
		nodes.get(3).addEdge(nodes.get(4));
		nodes.get(4).addEdge(nodes.get(3));


		visited = new boolean[nodes.size()];
		parents = new Vertex[nodes.size()];
		pathLength = new int[nodes.size()];
	}

	private void printGraph() {
		for (Vertex n : nodes) {
			System.out.print(n.num + "->");
			for (Edge e: n.edges) {
				System.out.print(e.next.num + ",");
			}
			System.out.println();

		}
	}

	private void dfs(int nodeIndex) {
		if (nodes.size() == 0)
			return;
		
		if(visited[nodeIndex]) return;

		Vertex s = nodes.get(nodeIndex);
		System.out.println("Visiting Node: " + nodeIndex);
		visited[s.num] = true;
		for(Edge e: s.edges)
		{
			dfs(e.next.num);
		}

	}
	

	private void bfs(int nodeIndex) {

		if (nodes.size() == 0)
			return;


		Queue<Vertex> q = new LinkedList<Vertex>();

		Vertex s = nodes.get(nodeIndex);

		q.add(s);

		while (!q.isEmpty()) {
			Vertex n = q.poll();
			visited[n.num] = true;
			System.out.println("Visited Node #" + n.num);

			for(Edge e: s.edges)
			{

				if (!visited[e.next.num])
					
				{
					pathLength[e.next.num] = pathLength[n.num]+1;
					parents[e.next.num] = n;
					q.add(nodes.get(e.next.num));
				}
			}
		}
		


	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.createGraph();
		g.printGraph();
//		System.out.println("BFS-----");
//		g.bfs(0);
//		for(int i=0; i < g.pathLength.length;i++)
//		{
//			System.out.println(i +": shorted path from root " + g.pathLength[i]);
//			System.out.println(i +": Parent In Tree " + (g.parents[i] == null ? "" : g.parents[i].num));
//		}
		System.out.println("DFS-----");
		g.dfs(0);

	}

}
