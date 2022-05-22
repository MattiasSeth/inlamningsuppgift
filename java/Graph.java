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
	
	public void dfs() {
		boolean[] visited = new boolean[adjacencylist.size()];
		
		for (int i=0; i<adjacencylist.size(); i++) {
			if(!visited[i])
				dfs_visit(i, visited);	
		}
		
	}
	
	public ArrayList<Set<Integer>> dfs2() {
		boolean[] visited = new boolean[adjacencylist.size()];
		ArrayList<Set<Integer>> result = new ArrayList<Set<Integer>>();
		
		Set<Integer> s = new HashSet<Integer>();
		
		for (int i=0; i<adjacencylist.size(); i++) {
			if(!visited[i]) {
				s = dfs_visit2(i, visited);
				result.add(s);
			}
			//result.add(s);

		}
		return result;
	}

	private Set<Integer> dfs_visit2(int v, boolean[] visited) {
		visited[v] = true;
		Set<Integer> r = new HashSet<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		s.add(getVertex(v));
		//System.out.println(getVertex(v) + " = visited" + "  S innehåller   " + s);
		
		for (int i=1; i<adjacencylist.get(v).size(); i++ ) {  // loop to get neighbors
			Vertex node = adjacencylist.get(v).get(i);
			int id = node.identifier;
			//System.out.println(id);
			
			for (int j=0; j<adjacencylist.size(); j++) { // loop to check if neighbors been visited.
				int id2 = getVertex(j);
				int x = j;
				
				if (id == id2) {                     // if neighbor = Vertex
					if(!visited[j]) {                // use index to see if not visited
						//System.out.println("RECURSION");
						r = dfs_visit2(x, visited);;
						s.addAll(r);					
						//System.out.println(s);					
						//System.out.println("");
					}
				} 

			}
		}

		return s;
		
	}
	
	private void dfs_visit(int v, boolean[] visited) {
		visited[v] = true;
		//System.out.println(getVertex(v) + " = visited");
		
		for (int i=1; i<adjacencylist.get(v).size(); i++ ) {      // loop to get neighbors
			Vertex node = adjacencylist.get(v).get(i);
			int id = node.identifier;
			//System.out.println(id);
			
			for (int j=0; j<adjacencylist.size(); j++) { // loop to check if neighbors been visited.
				int id2 = getVertex(j);
				int x = j;
				
				if (id == id2) {                     // if neighbor = Vertex
					if(!visited[j]) {                // use index to see if not visited
						//System.out.println("RECURSION");
						dfs_visit(x, visited);		
					}
				}	
			}
			
		}
	}

	public static void main(String[] args)throws Exception {
		
	ArrayList<Integer> nodesid1 = new ArrayList<Integer>();
	ArrayList<Integer> nodesid2 = new ArrayList<Integer>();
	ArrayList<Integer> tempnodes = new ArrayList<Integer>();
	
	//Scanner sc = new Scanner (new File("test2.txt"));
	Scanner sc = new Scanner (new File("/Users/harry/inlamningsuppgift/data/int_temp.txt"));
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
	
	
	//graph.dfs();
	
	graph.dfs2();
	
	ArrayList<Set<Integer>> test = new ArrayList<Set<Integer>>();
	
	int counter = 0;
	test = graph.dfs2();
	for (int i=0; i<test.size(); i++) {
		int check = test.get(i).size();
		if (check > 2)
			counter++;
		//System.out.println(test.get(i).size());
		}
	System.out.println("The number of components of G with at least three vertices is:  " +counter);	
	
	
	
	//int x = graph.count();
	//System.out.println(x);
	//graph.print();
	
	//System.out.print(graph.getVertex(5));
	//for (int i=0; i<graph.getSize(); i++)
		//graph.dfs(i);
}
	
}


























