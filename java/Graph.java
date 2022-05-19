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
	
	public int getSize() {
		return adjacencylist.size();
	}

	public int getVertex(int i) {
		Vertex node = adjacencylist.get(i).get(0);
		return node.identifier;
	}
	
	
	public static void main(String[] args)throws Exception {
		
	ArrayList<Integer> nodesid1 = new ArrayList<Integer>();
	ArrayList<Integer> nodesid2 = new ArrayList<Integer>();
	
	Scanner sc = new Scanner (new File("test1.txt"));
	while (sc.hasNext()) {
		int x = sc.nextInt();
		if (nodesid1.size() == nodesid2.size())			
			nodesid1.add(x);
		else
			nodesid2.add(x);
	}
	
	List<Graph> allGraphs = new ArrayList<Graph>();
	
	try {
		for (int i=0; i<nodesid1.size(); i++) {
			Graph graph = new Graph();
			
			int id1 = nodesid1.get(i);
			int id2 = nodesid2.get(i);
			
			if (graph.getSize() == 0) {	
				graph.addVertex(new Vertex(id1));      graph.addVertex(new Vertex(id2));
				graph.addEdge(i, i+1);                 graph.addEdge(i+1, i);
			} 
			
			else if (graph.getSize() > 0) {
				for (int j=0; j < graph.getSize(); j++) {
					if (graph.getVertex(j) == id1) {
						
					}
				}
			}
		}
		
	}
	catch (Exception e) {
		
	}
	
	
	/*
	for (int i=0;i<3;i++) {
		Graph x = new Graph();
		x.addVertex(new Vertex(i));
		allGraphs.add(x);
	}
	
	
	for (int i=0;i<allGraphs.size();i++) {
		allGraphs.get(i).print();
	}
	*/
	
	/*
	for (int i : nodesid1) {
		System.out.println(i);
	}
	*/
	
	/*
	for (int i=0; i<nodesid1.size(); i++) {
		System.out.println(nodesid1.get(i) + "  " + nodesid2.get(i));
	}
	*/	
	
	
	
	
	/*
	Graph graph = new Graph();
	
	graph.addVertex(new Vertex(1));
	graph.addVertex(new Vertex(2));
	graph.addVertex(new Vertex(4));
	graph.addVertex(new Vertex(3));
	
	System.out.println(graph.getVertex(1));
	
	for (int i=0; i<graph.getSize();i++)
		if (graph.getVertex(i) == i);
			System.out.println("Hej");
	
			
	System.out.println(graph.getSize());
	graph.addEdge(0, 1);
	graph.addEdge(1, 0);
	graph.addEdge(0, 3);
	graph.addEdge(3, 0);
	graph.addEdge(1, 2);
	graph.addEdge(2, 1);
	graph.addEdge(2, 3);
	graph.addEdge(3, 2);
	
	//graph.print();
	*/
}
	
}