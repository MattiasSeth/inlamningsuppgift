import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
	
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
				System.out.print(node.identifier + " <--> ");
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
	
	public void addEdges(int id1, int id2) {
		for(LinkedList<Vertex> currentList : adjacencylist) {
			if (currentList.getFirst().getVertex() == id1 ) {
				Vertex id2Node = new Vertex(id2);
				currentList.add(id2Node);
			}
			if (currentList.getFirst().getVertex() == id2 ) {
				Vertex id1Node = new Vertex(id1);
				currentList.add(id1Node);
			}
		}
	
	}
	
	public static void main(String[] args)throws Exception {
		
	ArrayList<Integer> nodesid1 = new ArrayList<Integer>();
	ArrayList<Integer> nodesid2 = new ArrayList<Integer>();
	ArrayList<Integer> tempnodes = new ArrayList<Integer>();
	
	Scanner sc = new Scanner (new File("test1.txt"));
	while (sc.hasNext()) {
		int x = sc.nextInt();
		tempnodes.add(x);
		if (nodesid1.size() == nodesid2.size())			
			nodesid1.add(x);
		else
			nodesid2.add(x);
	}
	
	List<Integer> uniqnodes = tempnodes.stream().distinct().collect(Collectors.toList());
	Collections.sort(uniqnodes);
	
	Graph graph = new Graph();
	for (int i=0; i<uniqnodes.size(); i++)
		graph.addVertex(new Vertex(uniqnodes.get(i)));
	
	for (int i=0; i<nodesid1.size(); i++) {
		graph.addEdges(nodesid1.get(i), nodesid2.get(i));
	}
	
	graph.print();

}
	
}