import java.io.*;
import java.util.*;
	
public class Graph {
	
	ArrayList<LinkedList<Vertex>> adjacencylist;
	
	Graph(){
		adjacencylist = new ArrayList<>();
	}
	
	public void addVertex(Vertex node) {
		LinkedList<Vertex> currentList = new LinkedList<>();
		currentList.add(node);
		adjacencylist.add(currentList);
	}
	
	public void addEdge(int id1, int id2) {
		LinkedList<Vertex> currentList = adjacencylist.get(id1);
		Vertex id2Node = adjacencylist.get(id2).get(0);
		currentList.add(id2Node);
	}
	
	public void print() {
		for(LinkedList<Vertex> currentList : adjacencylist) {
			for(Vertex node : currentList) {
				System.out.print(node.identifier + " x ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)throws Exception {
		
	ArrayList<Integer> nodes = new ArrayList<Integer>();
	Scanner sc = new Scanner (new File("test1.txt"));
	while (sc.hasNext()) {
		int x = sc.nextInt();
		nodes.add(x);	
	}
	
	try {
		for (int i=0; i<nodes.size()-1; i++) {
			Graph graph = new Graph();
			int id1 = nodes.get(i);
			int id2 = nodes.get(i+1);
			
			graph.addVertex(new Vertex(id1));
			graph.addVertex(new Vertex(id2));
			graph.addEdge(i, i+1);
			graph.addEdge(i+1, i);
		}
		
	}
	catch (Exception e) {
		
	}
	/*
	for (int i : nodes) {
		System.out.println(i);
	}
	*/
	/*
	Graph graph = new Graph();
	
	graph.addNode(new Vertex(1));
	graph.addNode(new Vertex(2));
	graph.addNode(new Vertex(4));
	graph.addNode(new Vertex(3));
	
	graph.addVertex(0, 1);
	graph.addVertex(1, 0);
	graph.addVertex(0, 3);
	graph.addVertex(3, 0);
	graph.addVertex(1, 2);
	graph.addVertex(2, 1);
	graph.addVertex(2, 3);
	graph.addVertex(3, 2);
	
	graph.print();
	*/
}
	
}